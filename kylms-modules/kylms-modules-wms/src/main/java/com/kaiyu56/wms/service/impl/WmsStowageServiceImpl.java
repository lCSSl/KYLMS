package com.kaiyu56.wms.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.common.core.exception.BaseException;
import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.common.core.utils.LambdaUtils;
import com.kaiyu56.common.core.utils.SecurityUtils;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.system.api.RemoteUserService;
import com.kaiyu56.system.api.domain.SysDept;
import com.kaiyu56.system.api.domain.SysUser;
import com.kaiyu56.system.api.model.LoginUser;
import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import com.kaiyu56.wms.domain.WmsStowage;
import com.kaiyu56.wms.domain.WmsStowageRoute;
import com.kaiyu56.wms.domain.WmsVehicle;
import com.kaiyu56.wms.enums.WmsStowageRouteStatus;
import com.kaiyu56.wms.enums.WmsStowageStatus;
import com.kaiyu56.wms.enums.WmsVehicleStatus;
import com.kaiyu56.wms.enums.WmsWaybillStatus;
import com.kaiyu56.wms.mapper.WmsStowageMapper;
import com.kaiyu56.wms.mapper.WmsWarehouseMapper;
import com.kaiyu56.wms.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 运单配载Service业务层处理
 *
 * @author css
 * @date 2021-04-08
 */
@Slf4j
@Service
public class WmsStowageServiceImpl extends ServiceImpl<WmsStowageMapper, WmsStowage> implements IWmsStowageService {

    @Autowired
    private RemoteUserService remoteUserService;

    @Autowired
    private IWmsWaybillService wmsWaybillService;
    @Autowired
    private IWmsStowageMdWaybillService stowageMdWaybillService;
    @Autowired
    private IWmsStowageRouteService stowageRouteService;
    @Autowired
    private IWmsVehicleService vehicleService;

    /**
     * 查询运单配载
     *
     * @param stowageId 运单配载ID
     * @return 运单配载
     */
    @Override
    public WmsStowage selectWmsStowageById(Long stowageId) {
        return baseMapper.selectWmsStowageById(stowageId);
    }

    /**
     * 查询运单配载列表
     *
     * @param wmsStowage 运单配载
     * @return 运单配载
     */
    @Override
    public List<WmsStowage> selectWmsStowageList(WmsStowage wmsStowage) {
        return baseMapper.selectWmsStowageList(wmsStowage);
    }

    /**
     * 新增运单配载
     *
     * @param wmsStowage 运单配载
     * @return 结果
     */
    @Override
    public int insertWmsStowage(WmsStowage wmsStowage) {
        wmsStowage.setCreateTime(DateUtils.getNowDate());
        return baseMapper.insertWmsStowage(wmsStowage);
    }

    @Override
    public WmsStowage insertWmsStowage(Map<String, Object> map) {
        JSONObject json = new JSONObject(map);
        if (StringUtils.isEmpty(map)) {
            log.error("Illegal input");
            throw new BaseException();
        }
        LoginUser loginUser = remoteUserService.getUserInfo(SecurityUtils.getUsername()).getData();
        SysUser sysUser = loginUser.getSysUser();
        SysDept dept = sysUser.getDept();
        WmsStowage wmsStowage = JSON.toJavaObject(json.getJSONObject("wmsStowage"), WmsStowage.class);
        if (!StringUtils.isNotNull(wmsStowage)) {
            log.error("Illegal input");
            throw new BaseException();
        }
        wmsStowage.setStowageCode("KY-SW-" + IdWorker.get32UUID().toUpperCase());
        wmsStowage.setDepartureCode("Not Define");
        wmsStowage.fillBasicAttributes(0);
        wmsStowage.setDeptId(dept.getDeptId());
        List<Long> ids = JSON.toJavaObject(json.getJSONArray("ids"), List.class);
        Long destination = wmsStowage.getDestination();
        if (StringUtils.isNotEmpty(ids)) {
            List<WmsWaybillVO> waybillVOList = wmsWaybillService.selectWmsWaybillVOListByIds(ids);
            waybillVOList.forEach(LambdaUtils.consumerWithIndex((item, index) -> {
                if (item.getDeparture().compareTo(wmsStowage.getDeparture()) != 0) {
                    throw new BaseException("请选择相同发出站点");
                }
                if (item.getDestination().compareTo(destination) != 0) {
                    throw new BaseException("请选择相同目的地站点");
                }
                if (!(WmsWaybillStatus.WAREHOUSING.getCode().equals(item.getWaybillStatus()) || WmsWaybillStatus.NEW.getCode().equals(item.getWaybillStatus()))) {
                    throw new BaseException("请选择正确状态运单进行配载");
                }
            }));
            baseMapper.insertWmsStowage(wmsStowage);
            Long stowageId = wmsStowage.getStowageId();
            WmsStowageRoute finalRoute = new WmsStowageRoute(IdWorker.getId(), stowageId, destination, wmsStowage.getDestinationName(), 127, WmsStowageRouteStatus.NOT_ARRIVED.getCode(), null);
            stowageRouteService.initWmsStowageRoute(new WmsStowageRoute(stowageId, wmsStowage.getDeparture(), wmsStowage.getDepartureName(), 0, WmsStowageRouteStatus.ARRIVED.getCode(), finalRoute.getRouteId()));
            stowageRouteService.initWmsStowageRoute(finalRoute);
            stowageMdWaybillService.insertBatchWmsStowageMdWaybill(finalRoute.getRouteId(), stowageId, waybillVOList);
            waybillVOList.forEach(item -> {
                wmsWaybillService.updateWmsWaybill(new WmsWaybill(item.getWaybillId(), WmsWaybillStatus.PRE_LOADING.getCode()));
            });
        } else {
            baseMapper.insertWmsStowage(wmsStowage);
            Long stowageId = wmsStowage.getStowageId();
            WmsStowageRoute finalRoute = new WmsStowageRoute(IdWorker.getId(), stowageId, destination, wmsStowage.getDestinationName(), 127, WmsStowageRouteStatus.NOT_ARRIVED.getCode(), null);
            stowageRouteService.initWmsStowageRoute(new WmsStowageRoute(stowageId, wmsStowage.getDeparture(), wmsStowage.getDepartureName(), 0, WmsStowageRouteStatus.ARRIVED.getCode(), finalRoute.getRouteId()));
            stowageRouteService.initWmsStowageRoute(finalRoute);
        }

        return wmsStowage;
    }

    /**
     * 修改运单配载
     *
     * @param wmsStowage 运单配载
     * @return 结果
     */
    @Override
    public int updateWmsStowage(WmsStowage wmsStowage) {
        wmsStowage.fillBasicAttributes(1);
        Map<String, Object> params = wmsStowage.getParams();
        if (StringUtils.isNotEmpty(params)) {
            JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params.get("prev")));
            WmsStowage prev = jsonObject.toJavaObject(WmsStowage.class);
            Long prevVehicleId = prev.getDepartureVehicleId();
            Long departureVehicleId = wmsStowage.getDepartureVehicleId();
            if (prevVehicleId != null && prevVehicleId.compareTo(0l) > 0) {
                if (prevVehicleId.compareTo(departureVehicleId) != 0) {
                    vehicleService.updateWmsVehicle(new WmsVehicle(prevVehicleId, WmsVehicleStatus.IDLE.getCode()));
                    vehicleService.updateWmsVehicle(new WmsVehicle(departureVehicleId, WmsVehicleStatus.USING.getCode()));
                }
            } else {
                vehicleService.updateWmsVehicle(new WmsVehicle(departureVehicleId, WmsVehicleStatus.USING.getCode()));
            }
        } else {
            log.warn("not have any params");
        }
        return baseMapper.updateWmsStowage(wmsStowage);
    }

    /**
     * 批量删除运单配载
     *
     * @param stowageIds 需要删除的运单配载ID
     * @return 结果
     */
    @Override
    public int deleteWmsStowageByIds(Long[] stowageIds) {
        throw new BaseException("配载无法批量删除");
//        return baseMapper.deleteWmsStowageByIds(stowageIds);
    }

    /**
     * 删除运单配载信息
     *
     * @param stowageId 运单配载ID
     * @return 结果
     */
    @Override
    public int deleteWmsStowageById(Long stowageId) {
        WmsStowage wmsStowage = selectWmsStowageById(stowageId);
        if (StringUtils.isNull(wmsStowage)) {
            throw new BaseException();
        }
        List<Long> waybillIds = stowageMdWaybillService.selectWaybillIdsByStowageId(stowageId);
        if (StringUtils.isNotEmpty(waybillIds)) {
            waybillIds.forEach(item -> {
                wmsWaybillService.updateWmsWaybill(new WmsWaybill(item, WmsWaybillStatus.WAREHOUSING.getCode()));
            });
        }
        Long departureVehicleId = wmsStowage.getDepartureVehicleId();
        if (StringUtils.isNotNull(departureVehicleId)) {
            vehicleService.updateWmsVehicle(new WmsVehicle(departureVehicleId, WmsVehicleStatus.IDLE.getCode()));
        }
        stowageRouteService.deleteWmsStowageRouteByStowageId(stowageId);
        stowageMdWaybillService.deleteWmsStowageMdWaybillByStowageId(stowageId);
        return baseMapper.deleteWmsStowageById(stowageId);
    }


    @Override
    public List<Long> selectWorkingDriver(Long[] userIds) {
        return baseMapper.selectWorkingDriver(userIds);
    }

    @Override
    public int endStowage(Long stowageId) {
        WmsStowage wmsStowage = selectWmsStowageById(stowageId);
        if (StringUtils.isNotNull(wmsStowage) && WmsStowageStatus.CREATED.getCode().equals(wmsStowage.getStowageStatus())) {
            if (!(StringUtils.checkLongKey(wmsStowage.getDepartureVehicleId()) && StringUtils.checkLongKey(wmsStowage.getDepartureDriverId()))) {
                throw new BaseException("配载参数有误");
            }
            List<Long> waybillIds = stowageMdWaybillService.selectWaybillIdsByStowageId(stowageId);
            stowageRouteService.selectRouteIdsByStowageIdWithStartNode(stowageId).forEach(i -> {
                int size = stowageMdWaybillService.selectWaybillIdsByRouteId(i).size();
                if (size <= 0) {
                    throw new BaseException("线路参数有误，请检查");
                }
            });
            waybillIds.forEach(item -> wmsWaybillService.updateWmsWaybill(new WmsWaybill(item, WmsWaybillStatus.LOADING.getCode())));
            wmsStowage.setStowageStatus(WmsStowageStatus.STOWAGE.getCode());
            return baseMapper.updateWmsStowage(wmsStowage);
        } else {
            throw new BaseException("配载状态有误");
        }
    }

    @Override
    public int departure(Long stowageId) {
        WmsStowage wmsStowage = selectWmsStowageById(stowageId);
        if (StringUtils.isNotNull(wmsStowage) && WmsStowageStatus.STOWAGE.getCode().equals(wmsStowage.getStowageStatus())) {
            Long departureVehicleId = wmsStowage.getDepartureVehicleId();
            if (!(StringUtils.checkLongKey(departureVehicleId) && StringUtils.checkLongKey(wmsStowage.getDepartureDriverId()))) {
                throw new BaseException("配载参数有误");
            }
            wmsStowage.setStowageStatus(WmsStowageStatus.DEPARTED.getCode());
            wmsStowage.setDepartureTime(DateUtils.getNowDate());
            List<Long> waybillIds = stowageMdWaybillService.selectWaybillIdsByStowageId(stowageId);
            waybillIds.forEach(item -> wmsWaybillService.updateWmsWaybill(new WmsWaybill(item, WmsWaybillStatus.DEPARTURE.getCode())));
            vehicleService.updateWmsVehicle(new WmsVehicle(departureVehicleId, WmsVehicleStatus.TRANSIT.getCode()));
            return baseMapper.updateWmsStowage(wmsStowage);
        } else {
            throw new BaseException("配载状态有误");
        }
    }
}
