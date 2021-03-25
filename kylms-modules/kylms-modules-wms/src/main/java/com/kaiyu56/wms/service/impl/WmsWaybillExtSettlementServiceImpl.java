package com.kaiyu56.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiyu56.wms.mapper.WmsWaybillExtSettlementMapper;
import com.kaiyu56.wms.domain.WmsWaybillExtSettlement;
import com.kaiyu56.wms.service.IWmsWaybillExtSettlementService;

/**
 * 运单拓展信息-费用Service业务层处理
 * 
 * @author css
 * @date 2021-03-24
 */
@Service
public class WmsWaybillExtSettlementServiceImpl implements IWmsWaybillExtSettlementService 
{
    @Autowired
    private WmsWaybillExtSettlementMapper wmsWaybillExtSettlementMapper;

    /**
     * 查询运单拓展信息-费用
     * 
     * @param wbSettlementId 运单拓展信息-费用ID
     * @return 运单拓展信息-费用
     */
    @Override
    public WmsWaybillExtSettlement selectWmsWaybillExtSettlementById(Long wbSettlementId)
    {
        return wmsWaybillExtSettlementMapper.selectWmsWaybillExtSettlementById(wbSettlementId);
    }

    /**
     * 查询运单拓展信息-费用列表
     * 
     * @param wmsWaybillExtSettlement 运单拓展信息-费用
     * @return 运单拓展信息-费用
     */
    @Override
    public List<WmsWaybillExtSettlement> selectWmsWaybillExtSettlementList(WmsWaybillExtSettlement wmsWaybillExtSettlement)
    {
        return wmsWaybillExtSettlementMapper.selectWmsWaybillExtSettlementList(wmsWaybillExtSettlement);
    }

    /**
     * 新增运单拓展信息-费用
     * 
     * @param wmsWaybillExtSettlement 运单拓展信息-费用
     * @return 结果
     */
    @Override
    public int insertWmsWaybillExtSettlement(WmsWaybillExtSettlement wmsWaybillExtSettlement)
    {
        return wmsWaybillExtSettlementMapper.insertWmsWaybillExtSettlement(wmsWaybillExtSettlement);
    }

    /**
     * 修改运单拓展信息-费用
     * 
     * @param wmsWaybillExtSettlement 运单拓展信息-费用
     * @return 结果
     */
    @Override
    public int updateWmsWaybillExtSettlement(WmsWaybillExtSettlement wmsWaybillExtSettlement)
    {
        return wmsWaybillExtSettlementMapper.updateWmsWaybillExtSettlement(wmsWaybillExtSettlement);
    }

    /**
     * 批量删除运单拓展信息-费用
     * 
     * @param wbSettlementIds 需要删除的运单拓展信息-费用ID
     * @return 结果
     */
    @Override
    public int deleteWmsWaybillExtSettlementByIds(Long[] wbSettlementIds)
    {
        return wmsWaybillExtSettlementMapper.deleteWmsWaybillExtSettlementByIds(wbSettlementIds);
    }

    /**
     * 删除运单拓展信息-费用信息
     * 
     * @param wbSettlementId 运单拓展信息-费用ID
     * @return 结果
     */
    @Override
    public int deleteWmsWaybillExtSettlementById(Long wbSettlementId)
    {
        return wmsWaybillExtSettlementMapper.deleteWmsWaybillExtSettlementById(wbSettlementId);
    }
}
