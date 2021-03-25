package com.kaiyu56.wms.service;

import java.util.List;
import com.kaiyu56.wms.domain.WmsWaybillExtSettlement;

/**
 * 运单拓展信息-费用Service接口
 * 
 * @author css
 * @date 2021-03-24
 */
public interface IWmsWaybillExtSettlementService 
{
    /**
     * 查询运单拓展信息-费用
     * 
     * @param wbSettlementId 运单拓展信息-费用ID
     * @return 运单拓展信息-费用
     */
    public WmsWaybillExtSettlement selectWmsWaybillExtSettlementById(Long wbSettlementId);

    /**
     * 查询运单拓展信息-费用列表
     * 
     * @param wmsWaybillExtSettlement 运单拓展信息-费用
     * @return 运单拓展信息-费用集合
     */
    public List<WmsWaybillExtSettlement> selectWmsWaybillExtSettlementList(WmsWaybillExtSettlement wmsWaybillExtSettlement);

    /**
     * 新增运单拓展信息-费用
     * 
     * @param wmsWaybillExtSettlement 运单拓展信息-费用
     * @return 结果
     */
    public int insertWmsWaybillExtSettlement(WmsWaybillExtSettlement wmsWaybillExtSettlement);

    /**
     * 修改运单拓展信息-费用
     * 
     * @param wmsWaybillExtSettlement 运单拓展信息-费用
     * @return 结果
     */
    public int updateWmsWaybillExtSettlement(WmsWaybillExtSettlement wmsWaybillExtSettlement);

    /**
     * 批量删除运单拓展信息-费用
     * 
     * @param wbSettlementIds 需要删除的运单拓展信息-费用ID
     * @return 结果
     */
    public int deleteWmsWaybillExtSettlementByIds(Long[] wbSettlementIds);

    /**
     * 删除运单拓展信息-费用信息
     * 
     * @param wbSettlementId 运单拓展信息-费用ID
     * @return 结果
     */
    public int deleteWmsWaybillExtSettlementById(Long wbSettlementId);
}
