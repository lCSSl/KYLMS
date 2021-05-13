package com.kaiyu56.wms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kaiyu56.wms.mapper.WmsWaybillMdWarehouseExtItemMapper;
import com.kaiyu56.wms.domain.WmsWaybillMdWarehouseExtItem;
import com.kaiyu56.wms.service.IWmsWaybillMdWarehouseExtItemService;

/**
 * 运单-仓库方格中间Service业务层处理
 *
 * @author css
 * @date 2021-03-24
 */
@Service
public class WmsWaybillMdWarehouseExtItemServiceImpl implements IWmsWaybillMdWarehouseExtItemService {
    @Autowired
    private WmsWaybillMdWarehouseExtItemMapper wmsWaybillMdWarehouseExtItemMapper;

    /**
     * 查询运单-仓库方格中间
     *
     * @param id 运单-仓库方格中间ID
     * @return 运单-仓库方格中间
     */
    @Override
    public WmsWaybillMdWarehouseExtItem selectWmsWaybillMdWarehouseExtItemById(Long id) {
        return wmsWaybillMdWarehouseExtItemMapper.selectWmsWaybillMdWarehouseExtItemById(id);
    }

    /**
     * 查询运单-仓库方格中间列表
     *
     * @param wmsWaybillMdWarehouseExtItem 运单-仓库方格中间
     * @return 运单-仓库方格中间
     */
    @Override
    public List<WmsWaybillMdWarehouseExtItem> selectWmsWaybillMdWarehouseExtItemList(WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem) {
        return wmsWaybillMdWarehouseExtItemMapper.selectWmsWaybillMdWarehouseExtItemList(wmsWaybillMdWarehouseExtItem);
    }

    /**
     * 新增运单-仓库方格中间
     *
     * @param wmsWaybillMdWarehouseExtItem 运单-仓库方格中间
     * @return 结果
     */
    @Override
    public int insertWmsWaybillMdWarehouseExtItem(WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem) {
        return wmsWaybillMdWarehouseExtItemMapper.insertWmsWaybillMdWarehouseExtItem(wmsWaybillMdWarehouseExtItem);
    }

    /**
     * 修改运单-仓库方格中间
     *
     * @param wmsWaybillMdWarehouseExtItem 运单-仓库方格中间
     * @return 结果
     */
    @Override
    public int updateWmsWaybillMdWarehouseExtItem(WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem) {
        return wmsWaybillMdWarehouseExtItemMapper.updateWmsWaybillMdWarehouseExtItem(wmsWaybillMdWarehouseExtItem);
    }

    /**
     * 批量删除运单-仓库方格中间
     *
     * @param ids 需要删除的运单-仓库方格中间ID
     * @return 结果
     */
    @Override
    public int deleteWmsWaybillMdWarehouseExtItemByIds(Long[] ids) {
        return wmsWaybillMdWarehouseExtItemMapper.deleteWmsWaybillMdWarehouseExtItemByIds(ids);
    }

    /**
     * 删除运单-仓库方格中间信息
     *
     * @param id 运单-仓库方格中间ID
     * @return 结果
     */
    @Override
    public int deleteWmsWaybillMdWarehouseExtItemById(Long id) {
        return wmsWaybillMdWarehouseExtItemMapper.deleteWmsWaybillMdWarehouseExtItemById(id);
    }

    @Override
    public Long selectItemIdByWaybillId(Long waybillId) {
        return wmsWaybillMdWarehouseExtItemMapper.selectItemIdByWaybillId(waybillId);
    }
}
