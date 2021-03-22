package com.kaiyu56.wms.service.impl;

import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.wms.api.domain.WmsWarehouse;
import com.kaiyu56.wms.api.domain.vo.WmsWarehouseVO;
import com.kaiyu56.wms.mapper.WmsWarehouseMapper;
import com.kaiyu56.wms.service.IWmsWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 站点(仓库)信息Service业务层处理
 *
 * @author css
 * @date 2021-03-22
 */
@Service
public class WmsWarehouseServiceImpl implements IWmsWarehouseService {
    @Autowired
    private WmsWarehouseMapper wmsWarehouseMapper;

    /**
     * 查询站点(仓库)信息
     *
     * @param warehouseId 站点(仓库)信息ID
     * @return 站点(仓库)信息
     */
    @Override
    public WmsWarehouse selectWmsWarehouseById(Long warehouseId) {
        return wmsWarehouseMapper.selectWmsWarehouseById(warehouseId);
    }

    /**
     * 查询站点(仓库)信息列表
     *
     * @param wmsWarehouse 站点(仓库)信息
     * @return 站点(仓库)信息
     */
    @Override
    public List<WmsWarehouse> selectWmsWarehouseList(WmsWarehouse wmsWarehouse) {
        return wmsWarehouseMapper.selectWmsWarehouseList(wmsWarehouse);
    }

    @Override
    public List<WmsWarehouseVO> selectWmsWarehouseVOList(WmsWarehouse wmsWarehouse) {
        return wmsWarehouseMapper.selectWmsWarehouseVOList(wmsWarehouse);
    }

    /**
     * 获取站点(仓库)负责人信息
     *
     * @return 获取站点(仓库)负责人信息
     */
    @Override
    public List<Long> selectAllWmsWarehouseInChargeIdList() {
        return wmsWarehouseMapper.selectAllWmsWarehouseInChargeIdList();
    }

    /**
     * 新增站点(仓库)信息
     *
     * @param wmsWarehouse 站点(仓库)信息
     * @return 结果
     */
    @Override
    public int insertWmsWarehouse(WmsWarehouse wmsWarehouse) {
        wmsWarehouse.setCreateTime(DateUtils.getNowDate());
        return wmsWarehouseMapper.insertWmsWarehouse(wmsWarehouse);
    }

    /**
     * 修改站点(仓库)信息
     *
     * @param wmsWarehouse 站点(仓库)信息
     * @return 结果
     */
    @Override
    public int updateWmsWarehouse(WmsWarehouse wmsWarehouse) {
        wmsWarehouse.setUpdateTime(DateUtils.getNowDate());
        return wmsWarehouseMapper.updateWmsWarehouse(wmsWarehouse);
    }

    /**
     * 批量删除站点(仓库)信息
     *
     * @param warehouseIds 需要删除的站点(仓库)信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsWarehouseByIds(Long[] warehouseIds) {
        return wmsWarehouseMapper.deleteWmsWarehouseByIds(warehouseIds);
    }

    /**
     * 删除站点(仓库)信息信息
     *
     * @param warehouseId 站点(仓库)信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsWarehouseById(Long warehouseId) {
        return wmsWarehouseMapper.deleteWmsWarehouseById(warehouseId);
    }
}
