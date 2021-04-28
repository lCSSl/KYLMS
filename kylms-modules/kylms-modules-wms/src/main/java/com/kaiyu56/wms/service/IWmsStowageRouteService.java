package com.kaiyu56.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaiyu56.wms.domain.WmsStowage;
import com.kaiyu56.wms.domain.WmsStowageRoute;
import com.kaiyu56.wms.domain.vo.ArrivalTicket;

import java.util.List;

/**
 * 运单配载线路Service接口
 *
 * @author css
 * @date 2021-04-08
 */
public interface IWmsStowageRouteService extends IService<WmsStowageRoute> {
    /**
     * 查询运单配载线路
     *
     * @param routeId 运单配载线路ID
     * @return 运单配载线路
     */
    public WmsStowageRoute selectWmsStowageRouteById(Long routeId);

    /**
     * 查询运单配载线路列表
     *
     * @param wmsStowageRoute 运单配载线路
     * @return 运单配载线路集合
     */
    public List<WmsStowageRoute> selectWmsStowageRouteList(WmsStowageRoute wmsStowageRoute);

    public List<Long> selectRouteIdsByStowageIdWithStartNode(Long stowageId);

    /**
     * 初始化运单配载线路
     *
     * @param wmsStowageRoute 运单配载信息
     * @return 结果
     */
    public int initWmsStowageRoute(WmsStowageRoute wmsStowageRoute);

    /**
     * 新增运单配载线路
     *
     * @param wmsStowageRoute 运单配载线路
     * @return 结果
     */
    public int insertWmsStowageRoute(WmsStowageRoute wmsStowageRoute);

    /**
     * 修改运单配载线路
     *
     * @param wmsStowageRoute 运单配载线路
     * @return 结果
     */
    public int updateWmsStowageRoute(WmsStowageRoute wmsStowageRoute);

    /**
     * 批量删除运单配载线路
     *
     * @param routeIds 需要删除的运单配载线路ID
     * @return 结果
     */
    public int deleteWmsStowageRouteByIds(Long[] routeIds);

    /**
     * 删除运单配载线路信息
     *
     * @param routeId 运单配载线路ID
     * @return 结果
     */
    public int deleteWmsStowageRouteById(Long routeId);
    /**
     * d
     * @param routeId
     * @return
     */
    public int deleteWmsStowageRouteByStowageId(Long routeId);

    /**
     * d
     * @param ticket
     * @return
     */
    int arrivalSite(ArrivalTicket ticket);
}
