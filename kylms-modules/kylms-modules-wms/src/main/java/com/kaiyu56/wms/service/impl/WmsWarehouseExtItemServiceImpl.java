package com.kaiyu56.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.wms.domain.WmsWarehouseExtItem;
import com.kaiyu56.wms.mapper.WmsWarehouseExtItemMapper;
import com.kaiyu56.wms.service.IWmsWarehouseExtItemService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 仓库拓展-仓库方格信息Service业务层处理
 *
 * @author css
 * @date 2021-03-24
 */
@Service
public class WmsWarehouseExtItemServiceImpl extends ServiceImpl<WmsWarehouseExtItemMapper, WmsWarehouseExtItem> implements IWmsWarehouseExtItemService {

    /**
     * 查询仓库拓展-仓库方格信息
     *
     * @param itemId 仓库拓展-仓库方格信息ID
     * @return 仓库拓展-仓库方格信息
     */
    @Override
    public WmsWarehouseExtItem selectWmsWarehouseExtItemById(Long itemId) {
        return baseMapper.selectWmsWarehouseExtItemById(itemId);
    }

    /**
     * 查询仓库拓展-仓库方格信息列表
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 仓库拓展-仓库方格信息
     */
    @Override
    public List<WmsWarehouseExtItem> selectWmsWarehouseExtItemList(WmsWarehouseExtItem wmsWarehouseExtItem) {
        return baseMapper.selectWmsWarehouseExtItemList(wmsWarehouseExtItem);
    }
    /**
     * 查询仓库拓展-仓库方格画布
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 仓库拓展-仓库方格信息集合
     */
    public HashMap<String, Object> selectWmsWarehouseExtItemMap(WmsWarehouseExtItem wmsWarehouseExtItem){

        List<WmsWarehouseExtItem> list = baseMapper.selectWmsWarehouseExtItemList(wmsWarehouseExtItem);
        return null;
    }
    /**
     * 新增仓库拓展-仓库方格信息
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 结果
     */
    @Override
    public int insertWmsWarehouseExtItem(WmsWarehouseExtItem wmsWarehouseExtItem) {
        wmsWarehouseExtItem.setCreateTime(DateUtils.getNowDate());
        return baseMapper.insertWmsWarehouseExtItem(wmsWarehouseExtItem);
    }

    /**
     * 修改仓库拓展-仓库方格信息
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 结果
     */
    @Override
    public int updateWmsWarehouseExtItem(WmsWarehouseExtItem wmsWarehouseExtItem) {
        wmsWarehouseExtItem.setUpdateTime(DateUtils.getNowDate());
        return baseMapper.updateWmsWarehouseExtItem(wmsWarehouseExtItem);
    }

    /**
     * 批量删除仓库拓展-仓库方格信息
     *
     * @param itemIds 需要删除的仓库拓展-仓库方格信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsWarehouseExtItemByIds(Long[] itemIds) {
        return baseMapper.deleteWmsWarehouseExtItemByIds(itemIds);
    }

    /**
     * 删除仓库拓展-仓库方格信息信息
     *
     * @param itemId 仓库拓展-仓库方格信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsWarehouseExtItemById(Long itemId) {
        return baseMapper.deleteWmsWarehouseExtItemById(itemId);
    }

    /**
     * 批量新增仓库拓展-仓库方格信息
     *
     * @param batch
     * @return
     */
    @Override
    public int batchInsertWmsWarehouseExtItem(List<WmsWarehouseExtItem> batch) {
        int i = baseMapper.batchInsertWmsWarehouseExtItem(batch);
        return i;
    }
}
