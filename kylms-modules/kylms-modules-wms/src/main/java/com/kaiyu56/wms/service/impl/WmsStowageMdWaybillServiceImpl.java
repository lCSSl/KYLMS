package com.kaiyu56.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.common.core.exception.BaseException;
import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import com.kaiyu56.wms.domain.WmsStowageMdWaybill;
import com.kaiyu56.wms.domain.WmsStowageRoute;
import com.kaiyu56.wms.enums.WmsWaybillStatus;
import com.kaiyu56.wms.mapper.WmsStowageMdWaybillMapper;
import com.kaiyu56.wms.service.IWmsStowageMdWaybillService;
import com.kaiyu56.wms.service.IWmsStowageRouteService;
import com.kaiyu56.wms.service.IWmsWaybillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 配载运单中间关联Service业务层处理
 *
 * @author css
 * @date 2021-04-08
 */
@Slf4j
@Service
public class WmsStowageMdWaybillServiceImpl extends ServiceImpl<WmsStowageMdWaybillMapper, WmsStowageMdWaybill> implements IWmsStowageMdWaybillService {

    @Autowired
    private IWmsWaybillService wmsWaybillService;

    @Autowired
    private IWmsStowageRouteService wmsStowageRouteService;

    /**
     * 查询配载运单中间关联
     *
     * @param routeId 配载运单中间关联ID
     * @return 配载运单中间关联
     */
    @Override
    public WmsStowageMdWaybill selectWmsStowageMdWaybillById(Long routeId) {
        return baseMapper.selectWmsStowageMdWaybillById(routeId);
    }

    /**
     * 查询配载运单中间关联
     *
     * @param routeId 配载运单中间关联ID
     * @return 配载运单中间关联
     */
    @Override
    public List<Long> selectWaybillIdsByRouteId(Long routeId) {
        return baseMapper.selectWaybillIdsByRouteId(routeId);
    }

    /**
     * 查询配载运单中间关联列表
     *
     * @param wmsStowageMdWaybill 配载运单中间关联
     * @return 配载运单中间关联
     */
    @Override
    public List<WmsStowageMdWaybill> selectWmsStowageMdWaybillList(WmsStowageMdWaybill wmsStowageMdWaybill) {
        return baseMapper.selectWmsStowageMdWaybillList(wmsStowageMdWaybill);
    }

    /**
     * 新增配载运单中间关联
     *
     * @param wmsStowageMdWaybill 配载运单中间关联
     * @return 结果
     */
    @Override
    public int insertWmsStowageMdWaybill(WmsStowageMdWaybill wmsStowageMdWaybill) {
        return baseMapper.insertWmsStowageMdWaybill(wmsStowageMdWaybill);
    }

    /**
     * 修改配载运单中间关联
     *
     * @param wmsStowageMdWaybill 配载运单中间关联
     * @return 结果
     */
    @Override
    public int updateWmsStowageMdWaybill(WmsStowageMdWaybill wmsStowageMdWaybill) {
        return baseMapper.updateWmsStowageMdWaybill(wmsStowageMdWaybill);
    }

    /**
     * 批量删除配载运单中间关联
     *
     * @param routeIds 需要删除的配载运单中间关联ID
     * @return 结果
     */
    @Override
    public int deleteWmsStowageMdWaybillByIds(Long[] routeIds) {
        return baseMapper.deleteWmsStowageMdWaybillByIds(routeIds);
    }

    @Override
    public int deleteWmsStowageMdWaybillByWaybillIds(Long[] waybillIds) {
        return baseMapper.deleteWmsStowageMdWaybillByWaybillIds(waybillIds);
    }

    /**
     * 删除配载运单中间关联信息
     *
     * @param routeId 配载运单中间关联ID
     * @return 结果
     */
    @Override
    public int deleteWmsStowageMdWaybillById(Long routeId) {
        return baseMapper.deleteWmsStowageMdWaybillById(routeId);
    }

    @Override
    public int deleteWmsStowageMdWaybillByStowageId(Long stowageId) {
        return baseMapper.deleteWmsStowageMdWaybillByStowageId(stowageId);
    }

    @Override
    public int insertBatchWmsStowageMdWaybill(Long routeId, Long stowageId, List<WmsWaybillVO> waybillIds) {
        return baseMapper.insertBatchWmsStowageMdWaybill(routeId, stowageId, waybillIds);
    }

    @Override
    public int insertBatchWmsStowageMdWaybill(Long routeId, Long stowageId, Long[] waybillIds) {
        return baseMapper.insertBatchWmsStowageMdWaybillArray(routeId, stowageId, waybillIds);
    }

    public List<Long> selectWaybillIdsByStowageId(Long stowageId) {
        return baseMapper.selectWaybillIdsByStowageId(stowageId);
    }

    public List<Long> selectRouteIdsByStowageId(Long stowageId) {
        return baseMapper.selectRouteIdsByStowageId(stowageId);
    }

    @Override
    public int deleteWaybillFormRoute(Long[] waybillIds) {
        int length = waybillIds.length;
        for (int i = length - 1; i >= 0; i--) {
            wmsWaybillService.updateWmsWaybill(new WmsWaybill(waybillIds[i], WmsWaybillStatus.WAREHOUSING.getCode()));
        }
        return deleteWmsStowageMdWaybillByWaybillIds(waybillIds);
    }

    @Override
    public int makeStowage(Long routeId, Long[] waybillIds) {
        WmsStowageRoute wmsStowageRoute = wmsStowageRouteService.selectWmsStowageRouteById(routeId);
        Long stowageId = wmsStowageRoute.getStowageId();
        List<WmsWaybillVO> wmsWaybillVOS = wmsWaybillService.selectWmsWaybillVOListByIds(Arrays.asList(waybillIds));
        wmsWaybillVOS.forEach(item->{
            if(item.getDestination().compareTo(wmsStowageRoute.getStowageWarehouseId())!=0){
                throw new BaseException("配载节点目的地不一致");
            }
            if (!(WmsWaybillStatus.WAREHOUSING.getCode().equals(item.getWaybillStatus()))){
                throw new BaseException("配载运单状态有误");
            }
        });
        for (int i = 0; i < waybillIds.length; i++) {
            wmsWaybillService.updateWmsWaybill(new WmsWaybill(waybillIds[i], WmsWaybillStatus.PRE_LOADING.getCode()));
        }
        return insertBatchWmsStowageMdWaybill(routeId, stowageId, waybillIds);
    }
}
