package com.kaiyu56.wms.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaiyu56.wms.domain.WmsWarehouseExtItem;

/**
 * 仓库拓展-仓库方格信息Mapper接口
 *
 * @author css
 * @date 2021-03-24
 */
public interface WmsWarehouseExtItemMapper extends BaseMapper<WmsWarehouseExtItem> {
    /**
     * 查询仓库拓展-仓库方格信息
     *
     * @param itemId 仓库拓展-仓库方格信息ID
     * @return 仓库拓展-仓库方格信息
     */
    public WmsWarehouseExtItem selectWmsWarehouseExtItemById(Long itemId);

    public WmsWarehouseExtItem selectWmsWarehouseExtItemByXY(WmsWarehouseExtItem item);

    /**
     * 查询仓库拓展-仓库方格信息列表
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 仓库拓展-仓库方格信息集合
     */
    public List<WmsWarehouseExtItem> selectWmsWarehouseExtItemList(WmsWarehouseExtItem wmsWarehouseExtItem);

    /**
     * 新增仓库拓展-仓库方格信息
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 结果
     */
    public int insertWmsWarehouseExtItem(WmsWarehouseExtItem wmsWarehouseExtItem);

    /**
     * 修改仓库拓展-仓库方格信息
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 结果
     */
    public int updateWmsWarehouseExtItem(WmsWarehouseExtItem wmsWarehouseExtItem);

    /**
     * 删除仓库拓展-仓库方格信息
     *
     * @param itemId 仓库拓展-仓库方格信息ID
     * @return 结果
     */
    public int deleteWmsWarehouseExtItemById(Long itemId);

    /**
     * 批量删除仓库拓展-仓库方格信息
     *
     * @param itemIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsWarehouseExtItemByIds(Long[] itemIds);

    /**
     * 批量新增仓库拓展-仓库方格信息
     *
     * @param batch
     * @return
     */
    int batchInsertWmsWarehouseExtItem(List<WmsWarehouseExtItem> batch);
}
