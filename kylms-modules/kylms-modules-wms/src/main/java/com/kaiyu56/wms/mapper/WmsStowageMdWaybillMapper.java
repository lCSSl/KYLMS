package com.kaiyu56.wms.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import com.kaiyu56.wms.domain.WmsStowageMdWaybill;
import org.springframework.data.repository.query.Param;

/**
 * 配载运单中间关联Mapper接口
 *
 * @author css
 * @date 2021-04-08
 */
public interface WmsStowageMdWaybillMapper extends BaseMapper<WmsStowageMdWaybill> {
    /**
     * 查询配载运单中间关联
     *
     * @param routeId 配载运单中间关联ID
     * @return 配载运单中间关联
     */
    public WmsStowageMdWaybill selectWmsStowageMdWaybillById(Long routeId);

    public List<Long> selectWaybillIdsByRouteId(Long routeId);

    /**
     * 查询配载运单中间关联列表
     *
     * @param wmsStowageMdWaybill 配载运单中间关联
     * @return 配载运单中间关联集合
     */
    public List<WmsStowageMdWaybill> selectWmsStowageMdWaybillList(WmsStowageMdWaybill wmsStowageMdWaybill);

    /**
     * 新增配载运单中间关联
     *
     * @param wmsStowageMdWaybill 配载运单中间关联
     * @return 结果
     */
    public int insertWmsStowageMdWaybill(WmsStowageMdWaybill wmsStowageMdWaybill);

    /**
     * 修改配载运单中间关联
     *
     * @param wmsStowageMdWaybill 配载运单中间关联
     * @return 结果
     */
    public int updateWmsStowageMdWaybill(WmsStowageMdWaybill wmsStowageMdWaybill);

    /**
     * 删除配载运单中间关联
     *
     * @param routeId 配载运单中间关联ID
     * @return 结果
     */
    public int deleteWmsStowageMdWaybillById(Long routeId);
    public int deleteWmsStowageMdWaybillByStowageId(Long stowageId);

    /**
     * 批量删除配载运单中间关联
     *
     * @param routeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsStowageMdWaybillByIds(Long[] routeIds);
    public int deleteWmsStowageMdWaybillByWaybillIds(Long[] waybillIds);

    int insertBatchWmsStowageMdWaybill(@Param("routeId")Long routeId,@Param("stowageId")Long stowageId,@Param("waybillIds")List<WmsWaybillVO> waybillIds);

    int insertBatchWmsStowageMdWaybillArray(@Param("routeId")Long routeId,@Param("stowageId")Long stowageId,@Param("waybillIds")Long[] waybillIds);

    List<Long> selectWaybillIdsByStowageId(Long stowageId);
    List<Long> selectRouteIdsByStowageId(Long stowageId);
}
