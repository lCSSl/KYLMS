package com.kaiyu56.wms.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaiyu56.wms.domain.WmsStowageRoute;
import org.apache.ibatis.annotations.Param;

/**
 * 运单配载线路Mapper接口
 *
 * @author css
 * @date 2021-04-08
 */
public interface WmsStowageRouteMapper extends BaseMapper<WmsStowageRoute> {
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
     * 删除运单配载线路
     *
     * @param routeId 运单配载线路ID
     * @return 结果
     */
    public int deleteWmsStowageRouteById(Long routeId);

    /**
     * 批量删除运单配载线路
     *
     * @param routeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsStowageRouteByIds(Long[] routeIds);

    int deleteWmsStowageRouteByStowageId(Long stowageId);

    WmsStowageRoute selectWmsStowageRouteByRouteNext(Long routeNext);

    WmsStowageRoute selectFirstWmsStowageRoute(Long stowageId);
    int selectWmsStowageRouteByStowageWarehouseId(@Param("stowageId") Long stowageId,@Param("stowageWarehouseId") Long stowageWarehouseId);
    List<Long> selectRouteIdsByStowageIdWithStartNode(@Param("stowageId") Long stowageId);
}
