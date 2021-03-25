package com.kaiyu56.wms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaiyu56.wms.api.domain.WmsWarehouse;
import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.kaiyu56.wms.api.domain.vo.WmsWarehouseVO;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.List;

/**
 * 站点(仓库)信息Service接口
 * 
 * @author css
 * @date 2021-03-22
 */
public interface IWmsWarehouseService extends IService<WmsWarehouse>
{
    /**
     * 查询站点(仓库)信息
     * 
     * @param warehouseId 站点(仓库)信息ID
     * @return 站点(仓库)信息
     */
    public WmsWarehouse selectWmsWarehouseById(Long warehouseId);

    /**
     * 查询站点(仓库)信息列表
     * 
     * @param wmsWarehouse 站点(仓库)信息
     * @return 站点(仓库)信息集合
     */
    public List<WmsWarehouse> selectWmsWarehouseList(WmsWarehouse wmsWarehouse);

    /**
     * 查询站点(仓库)信息列表
     *
     * @param wmsWarehouse 站点(仓库)信息
     * @return 站点(仓库)信息集合
     */
    public List<WmsWarehouseVO> selectWmsWarehouseVOList(WmsWarehouse wmsWarehouse);

    /**
     * 获取站点(仓库)负责人信息
     *
     * @return 获取站点(仓库)负责人信息
     */
    public List<Long> selectAllWmsWarehouseInChargeIdList();

    /**
     * 新增站点(仓库)信息
     * 
     * @param wmsWarehouse 站点(仓库)信息
     * @return 结果
     */
    public int insertWmsWarehouse(WmsWarehouse wmsWarehouse);
    /**
     * 修改站点(仓库)信息
     *
     * @param wmsWarehouse 站点(仓库)信息
     * @return 结果
     */
    public int updateWmsWarehouse(WmsWarehouse wmsWarehouse);

    /**
     * 批量删除站点(仓库)信息
     *
     * @param warehouseIds 需要删除的站点(仓库)信息ID
     * @return 结果
     */
    public int deleteWmsWarehouseByIds(Long[] warehouseIds);

    /**
     * 删除站点(仓库)信息信息
     *
     * @param warehouseId 站点(仓库)信息ID
     * @return 结果
     */
    public int deleteWmsWarehouseById(Long warehouseId);

    /**
     * 初始化站点(仓库)方格
     * @param warehouseId
     * @param dictCode
     * @param trayType
     * @param trayInterval
     * @return
     */
    public int initWmsWarehouseExtItem(Long warehouseId,Long dictCode,String trayType,BigDecimal trayInterval);
}
