package com.kaiyu56.wms.service;

import java.util.List;

import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;

/**
 * 运单信息主Service接口
 *
 * @author css
 * @date 2021-03-20
 */
public interface IWmsWaybillService extends IService<WmsWaybill> {
    /**
     * 查询运单信息主
     *
     * @param waybillId 运单信息主ID
     * @return 运单信息主
     */
    public WmsWaybill selectWmsWaybillById(Long waybillId);

    /**
     * 查询运单信息主列表
     *
     * @param wmsWaybill 运单信息主
     * @return 运单信息主集合
     */
    public List<WmsWaybill> selectWmsWaybillList(WmsWaybill wmsWaybill);

    public List<WmsWaybillVO> selectWmsWaybillVOList(WmsWaybillVO vo);
    public List<WmsWaybillVO> selectWmsWaybillVOList(Long routeId);
    public int insertWmsWaybill(WmsWaybill wmsWaybill);
    public WmsWaybill updateWmsWaybill(WmsWaybill wmsWaybill);

    public List<WmsWaybillVO> selectWmsWaybillVOListByIds(List<Long> ids);

}
