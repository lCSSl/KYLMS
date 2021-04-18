package com.kaiyu56.wms.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.common.core.enums.BaseEntityFillType;
import com.kaiyu56.common.core.exception.BaseException;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.wms.domain.WmsStowageRoute;
import com.kaiyu56.wms.mapper.WmsStowageRouteMapper;
import com.kaiyu56.wms.mapper.WmsWarehouseMapper;
import com.kaiyu56.wms.service.IWmsStowageRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 运单配载线路Service业务层处理
 *
 * @author css
 * @date 2021-04-08
 */
@Slf4j
@Service
public class WmsStowageRouteServiceImpl extends ServiceImpl<WmsStowageRouteMapper, WmsStowageRoute> implements IWmsStowageRouteService {

    @Autowired
    private WmsWarehouseMapper wmsWarehouseMapper;
    /**
     * 查询运单配载线路
     *
     * @param routeId 运单配载线路ID
     * @return 运单配载线路
     */
    @Override
    public WmsStowageRoute selectWmsStowageRouteById(Long routeId) {
        return baseMapper.selectWmsStowageRouteById(routeId);
    }

    /**
     * 查询运单配载线路列表
     *
     * @param wmsStowageRoute 运单配载线路
     * @return 运单配载线路
     */
    @Override
    public List<WmsStowageRoute> selectWmsStowageRouteList(WmsStowageRoute wmsStowageRoute) {
        WmsStowageRoute first = baseMapper.selectFirstWmsStowageRoute(wmsStowageRoute.getStowageId());
        List list = new ArrayList();
        list.add(first);
        checkNext(list, first.getRouteNext());
        return list;
    }
    @Override
    public List<Long> selectRouteIdsByStowageIdWithStartNode(Long stowageId){
        return baseMapper.selectRouteIdsByStowageIdWithStartNode(stowageId);
    }
    private void checkNext(List list, Long next) {
        if (next != null && next.compareTo(0l) > 0) {
            WmsStowageRoute wmsStowageRoute = baseMapper.selectWmsStowageRouteById(next);
            list.add(wmsStowageRoute);
            checkNext(list, wmsStowageRoute.getRouteNext());
        }
    }

    /**
     * 初始化运单配载线路
     *
     * @param wmsStowageRoute 运单配载信息
     * @return 结果
     */
    public int initWmsStowageRoute(WmsStowageRoute wmsStowageRoute) {
        return baseMapper.insertWmsStowageRoute(wmsStowageRoute);
    }

    /**
     * 新增运单配载线路
     *
     * @param wmsStowageRoute 运单配载线路
     * @return 结果
     */
    @Override
    public int insertWmsStowageRoute(WmsStowageRoute wmsStowageRoute) {
        wmsStowageRoute.fillBasicAttributes(BaseEntityFillType.INSERT.getCode());
        Map<String, Object> params = wmsStowageRoute.getParams();
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params.get("prevRoute")));
        WmsStowageRoute prevRoute = jsonObject.toJavaObject(WmsStowageRoute.class);
        if (StringUtils.isEmpty(params) && StringUtils.isNull(prevRoute)) {
            log.error("map params is Empty : {}", params);
            throw new BaseException("参数有误");
        }
        Long routeId = prevRoute.getRouteId();
        if (routeId == null && routeId.compareTo(0l) <= 0) {
            throw new BaseException("参数有误");
        }
        if (prevRoute.getStowageId().compareTo(wmsStowageRoute.getStowageId())!=0){
            throw new BaseException();
        }
        if (baseMapper.selectWmsStowageRouteByStowageWarehouseId(wmsStowageRoute.getStowageId(),wmsStowageRoute.getStowageWarehouseId())>0){
            throw new BaseException("已有此节点");
        }
        wmsStowageRoute.setRouteNext(prevRoute.getRouteNext());
        wmsStowageRoute.setRouteSort(prevRoute.getRouteSort()+1);
        baseMapper.insertWmsStowageRoute(wmsStowageRoute);
        prevRoute.setRouteNext(wmsStowageRoute.getRouteId());
        return updateWmsStowageRoute(prevRoute);
    }

    /**
     * 修改运单配载线路
     *
     * @param wmsStowageRoute 运单配载线路
     * @return 结果
     */
    @Override
    public int updateWmsStowageRoute(WmsStowageRoute wmsStowageRoute) {
        int routeSort = wmsStowageRoute.getRouteSort();
        if (routeSort == 127) {
            throw new BaseException("不得操作末节点");
        }
        if (routeSort == 0) {
            Long routeId = wmsStowageRoute.getRouteId();
            String routeStatus = wmsStowageRoute.getRouteStatus();
            Long routeNext = wmsStowageRoute.getRouteNext();
            wmsStowageRoute = new WmsStowageRoute(routeId, routeSort, routeStatus, routeNext);
        }
        wmsStowageRoute.fillBasicAttributes(BaseEntityFillType.UPDATE.getCode());
        return baseMapper.updateWmsStowageRoute(wmsStowageRoute);
    }

    /**
     * 批量删除运单配载线路
     *
     * @param routeIds 需要删除的运单配载线路ID
     * @return 结果
     */
    @Override
    public int deleteWmsStowageRouteByIds(Long[] routeIds) {
        return baseMapper.deleteWmsStowageRouteByIds(routeIds);
    }

    /**
     * 删除运单配载线路信息
     *
     * @param routeId 运单配载线路ID
     * @return 结果
     */
    @Override
    public int deleteWmsStowageRouteById(Long routeId) {
        WmsStowageRoute wmsStowageRoute = selectWmsStowageRouteById(routeId);
        if (wmsStowageRoute == null) {
            throw new BaseException();
        }
        int routeSort = wmsStowageRoute.getRouteSort();
        if (routeSort == 0 || routeSort == 127) {
            throw new BaseException("不得操作始末节点");
        }
        WmsStowageRoute prev = baseMapper.selectWmsStowageRouteByRouteNext(routeId);
        prev.setRouteNext(wmsStowageRoute.getRouteNext());
        updateWmsStowageRoute(prev);
        return baseMapper.deleteWmsStowageRouteById(routeId);
    }

    @Override
    public int deleteWmsStowageRouteByStowageId(Long stowageId) {
        return baseMapper.deleteWmsStowageRouteByStowageId(stowageId);
    }
}
