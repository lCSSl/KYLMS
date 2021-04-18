package com.kaiyu56.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import com.kaiyu56.wms.domain.WmsStowageMdWaybill;
import com.kaiyu56.wms.domain.WmsStowageRoute;

import java.util.List;

/**
 * 配载运单中间关联Service接口
 *
 * @author css
 * @date 2021-04-08
 */
public interface IWmsStowageMdWaybillService extends IService<WmsStowageMdWaybill> {
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
     * 批量删除配载运单中间关联
     *
     * @param routeIds 需要删除的配载运单中间关联ID
     * @return 结果
     */
    public int deleteWmsStowageMdWaybillByIds(Long[] routeIds);

    public int deleteWmsStowageMdWaybillByWaybillIds(Long[] waybillIds);

    /**
     * 删除配载运单中间关联信息
     *
     * @param routeId 配载运单中间关联ID
     * @return 结果
     */
    public int deleteWmsStowageMdWaybillById(Long routeId);

    public int deleteWmsStowageMdWaybillByStowageId(Long routeId);

    public int insertBatchWmsStowageMdWaybill(Long routeId, Long stowageId, List<WmsWaybillVO> waybillIds);
    public int insertBatchWmsStowageMdWaybill(Long routeId, Long stowageId, Long[] waybillIds);

    public List<Long> selectWaybillIdsByStowageId(Long stowageId);

    public List<Long> selectRouteIdsByStowageId(Long stowageId);

    int deleteWaybillFormRoute(Long[] waybillIds);

    int makeStowage(Long routeId, Long[] waybillIds);
}
