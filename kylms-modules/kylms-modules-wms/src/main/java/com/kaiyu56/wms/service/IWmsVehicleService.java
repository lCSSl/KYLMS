package com.kaiyu56.wms.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaiyu56.wms.api.domain.vo.WmsVehicleLL;
import com.kaiyu56.wms.domain.WmsVehicle;

/**
 * 运输工具信息主Service接口
 * 
 * @author css
 * @date 2021-03-24
 */
public interface IWmsVehicleService extends IService<WmsVehicle>
{
    /**
     * 查询运输工具信息主
     * 
     * @param vehicleId 运输工具信息主ID
     * @return 运输工具信息主
     */
    public WmsVehicle selectWmsVehicleById(Long vehicleId);

    /**
     * 查询运输工具信息主列表
     * 
     * @param wmsVehicle 运输工具信息主
     * @return 运输工具信息主集合
     */
    public List<WmsVehicle> selectWmsVehicleList(WmsVehicle wmsVehicle);

    /**
     * 新增运输工具信息主
     * 
     * @param wmsVehicle 运输工具信息主
     * @return 结果
     */
    public int insertWmsVehicle(WmsVehicle wmsVehicle);

    /**
     * 修改运输工具信息主
     * 
     * @param wmsVehicle 运输工具信息主
     * @return 结果
     */
    public int updateWmsVehicle(WmsVehicle wmsVehicle);

    /**
     * 批量删除运输工具信息主
     * 
     * @param vehicleIds 需要删除的运输工具信息主ID
     * @return 结果
     */
    public int deleteWmsVehicleByIds(Long[] vehicleIds);

    /**
     * 删除运输工具信息主信息
     * 
     * @param vehicleId 运输工具信息主ID
     * @return 结果
     */
    public int deleteWmsVehicleById(Long vehicleId);

    WmsVehicleLL getLocationById(Long vehicleId);
}
