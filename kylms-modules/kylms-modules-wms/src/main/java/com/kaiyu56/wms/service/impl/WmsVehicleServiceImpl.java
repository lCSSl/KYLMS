package com.kaiyu56.wms.service.impl;

import java.util.List;
import com.kaiyu56.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiyu56.wms.mapper.WmsVehicleMapper;
import com.kaiyu56.wms.domain.WmsVehicle;
import com.kaiyu56.wms.service.IWmsVehicleService;

/**
 * 运输工具信息主Service业务层处理
 * 
 * @author css
 * @date 2021-03-24
 */
@Service
public class WmsVehicleServiceImpl implements IWmsVehicleService 
{
    @Autowired
    private WmsVehicleMapper wmsVehicleMapper;

    /**
     * 查询运输工具信息主
     * 
     * @param vehicleId 运输工具信息主ID
     * @return 运输工具信息主
     */
    @Override
    public WmsVehicle selectWmsVehicleById(Long vehicleId)
    {
        return wmsVehicleMapper.selectWmsVehicleById(vehicleId);
    }

    /**
     * 查询运输工具信息主列表
     * 
     * @param wmsVehicle 运输工具信息主
     * @return 运输工具信息主
     */
    @Override
    public List<WmsVehicle> selectWmsVehicleList(WmsVehicle wmsVehicle)
    {
        return wmsVehicleMapper.selectWmsVehicleList(wmsVehicle);
    }

    /**
     * 新增运输工具信息主
     * 
     * @param wmsVehicle 运输工具信息主
     * @return 结果
     */
    @Override
    public int insertWmsVehicle(WmsVehicle wmsVehicle)
    {
        wmsVehicle.setCreateTime(DateUtils.getNowDate());
        return wmsVehicleMapper.insertWmsVehicle(wmsVehicle);
    }

    /**
     * 修改运输工具信息主
     * 
     * @param wmsVehicle 运输工具信息主
     * @return 结果
     */
    @Override
    public int updateWmsVehicle(WmsVehicle wmsVehicle)
    {
        wmsVehicle.setUpdateTime(DateUtils.getNowDate());
        return wmsVehicleMapper.updateWmsVehicle(wmsVehicle);
    }

    /**
     * 批量删除运输工具信息主
     * 
     * @param vehicleIds 需要删除的运输工具信息主ID
     * @return 结果
     */
    @Override
    public int deleteWmsVehicleByIds(Long[] vehicleIds)
    {
        return wmsVehicleMapper.deleteWmsVehicleByIds(vehicleIds);
    }

    /**
     * 删除运输工具信息主信息
     * 
     * @param vehicleId 运输工具信息主ID
     * @return 结果
     */
    @Override
    public int deleteWmsVehicleById(Long vehicleId)
    {
        return wmsVehicleMapper.deleteWmsVehicleById(vehicleId);
    }
}
