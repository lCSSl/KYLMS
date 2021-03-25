package com.kaiyu56.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiyu56.wms.mapper.WmsCargoTempMapper;
import com.kaiyu56.wms.domain.WmsCargoTemp;
import com.kaiyu56.wms.service.IWmsCargoTempService;

/**
 * 运单货物临时Service业务层处理
 * 
 * @author css
 * @date 2021-03-24
 */
@Service
public class WmsCargoTempServiceImpl implements IWmsCargoTempService 
{
    @Autowired
    private WmsCargoTempMapper wmsCargoTempMapper;

    /**
     * 查询运单货物临时
     * 
     * @param id 运单货物临时ID
     * @return 运单货物临时
     */
    @Override
    public WmsCargoTemp selectWmsCargoTempById(Long id)
    {
        return wmsCargoTempMapper.selectWmsCargoTempById(id);
    }

    /**
     * 查询运单货物临时列表
     * 
     * @param wmsCargoTemp 运单货物临时
     * @return 运单货物临时
     */
    @Override
    public List<WmsCargoTemp> selectWmsCargoTempList(WmsCargoTemp wmsCargoTemp)
    {
        return wmsCargoTempMapper.selectWmsCargoTempList(wmsCargoTemp);
    }

    /**
     * 新增运单货物临时
     * 
     * @param wmsCargoTemp 运单货物临时
     * @return 结果
     */
    @Override
    public int insertWmsCargoTemp(WmsCargoTemp wmsCargoTemp)
    {
        return wmsCargoTempMapper.insertWmsCargoTemp(wmsCargoTemp);
    }

    /**
     * 修改运单货物临时
     * 
     * @param wmsCargoTemp 运单货物临时
     * @return 结果
     */
    @Override
    public int updateWmsCargoTemp(WmsCargoTemp wmsCargoTemp)
    {
        return wmsCargoTempMapper.updateWmsCargoTemp(wmsCargoTemp);
    }

    /**
     * 批量删除运单货物临时
     * 
     * @param ids 需要删除的运单货物临时ID
     * @return 结果
     */
    @Override
    public int deleteWmsCargoTempByIds(Long[] ids)
    {
        return wmsCargoTempMapper.deleteWmsCargoTempByIds(ids);
    }

    /**
     * 删除运单货物临时信息
     * 
     * @param id 运单货物临时ID
     * @return 结果
     */
    @Override
    public int deleteWmsCargoTempById(Long id)
    {
        return wmsCargoTempMapper.deleteWmsCargoTempById(id);
    }
}
