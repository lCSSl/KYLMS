package com.kaiyu56.wms.service.impl;

import java.util.List;
import com.kaiyu56.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiyu56.wms.mapper.WmsStowageMapper;
import com.kaiyu56.wms.domain.WmsStowage;
import com.kaiyu56.wms.service.IWmsStowageService;

/**
 * 运单配载Service业务层处理
 * 
 * @author css
 * @date 2021-03-24
 */
@Service
public class WmsStowageServiceImpl implements IWmsStowageService 
{
    @Autowired
    private WmsStowageMapper wmsStowageMapper;

    /**
     * 查询运单配载
     * 
     * @param stowageId 运单配载ID
     * @return 运单配载
     */
    @Override
    public WmsStowage selectWmsStowageById(Long stowageId)
    {
        return wmsStowageMapper.selectWmsStowageById(stowageId);
    }

    /**
     * 查询运单配载列表
     * 
     * @param wmsStowage 运单配载
     * @return 运单配载
     */
    @Override
    public List<WmsStowage> selectWmsStowageList(WmsStowage wmsStowage)
    {
        return wmsStowageMapper.selectWmsStowageList(wmsStowage);
    }

    /**
     * 新增运单配载
     * 
     * @param wmsStowage 运单配载
     * @return 结果
     */
    @Override
    public int insertWmsStowage(WmsStowage wmsStowage)
    {
        wmsStowage.setCreateTime(DateUtils.getNowDate());
        return wmsStowageMapper.insertWmsStowage(wmsStowage);
    }

    /**
     * 修改运单配载
     * 
     * @param wmsStowage 运单配载
     * @return 结果
     */
    @Override
    public int updateWmsStowage(WmsStowage wmsStowage)
    {
        wmsStowage.setUpdateTime(DateUtils.getNowDate());
        return wmsStowageMapper.updateWmsStowage(wmsStowage);
    }

    /**
     * 批量删除运单配载
     * 
     * @param stowageIds 需要删除的运单配载ID
     * @return 结果
     */
    @Override
    public int deleteWmsStowageByIds(Long[] stowageIds)
    {
        return wmsStowageMapper.deleteWmsStowageByIds(stowageIds);
    }

    /**
     * 删除运单配载信息
     * 
     * @param stowageId 运单配载ID
     * @return 结果
     */
    @Override
    public int deleteWmsStowageById(Long stowageId)
    {
        return wmsStowageMapper.deleteWmsStowageById(stowageId);
    }
}
