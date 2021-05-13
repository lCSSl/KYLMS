package com.kaiyu56.wms.service;

import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.kaiyu56.wms.domain.WmsWarehouseExtItem;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 仓库拓展-仓库方格信息Service接口
 *
 * @author css
 * @date 2021-03-24
 */
public interface IWmsWarehouseExtItemService extends IService<WmsWarehouseExtItem> {
    /**
     * 查询仓库拓展-仓库方格信息
     *
     * @param itemId 仓库拓展-仓库方格信息ID
     * @return 仓库拓展-仓库方格信息
     */
    public WmsWarehouseExtItem selectWmsWarehouseExtItemById(Long itemId);

    public WmsWarehouseExtItem selectWmsWarehouseExtItemByXY(WmsWarehouseExtItem wmsWarehouseExtItem);

    public WmsWaybill selectWmsWaybillInfoByItemId(Long itemId);

    /**
     * 查询仓库拓展-仓库方格信息列表
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 仓库拓展-仓库方格信息集合
     */
    public List<WmsWarehouseExtItem> selectWmsWarehouseExtItemList(WmsWarehouseExtItem wmsWarehouseExtItem);

    /**
     * 查询仓库拓展-仓库方格画布
     *
     * @param wmsWarehouseExtItem 仓库拓展-仓库方格信息
     * @return 仓库拓展-仓库方格信息集合
     */
    public HashMap<String, Object> selectWmsWarehouseExtItemMap(WmsWarehouseExtItem wmsWarehouseExtItem);

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
     * 批量删除仓库拓展-仓库方格信息
     *
     * @param itemIds 需要删除的仓库拓展-仓库方格信息ID
     * @return 结果
     */
    public int deleteWmsWarehouseExtItemByIds(Long[] itemIds);

    /**
     * 删除仓库拓展-仓库方格信息信息
     *
     * @param itemId 仓库拓展-仓库方格信息ID
     * @return 结果
     */
    public int deleteWmsWarehouseExtItemById(Long itemId);

    /**
     * 批量新增仓库拓展-仓库方格信息
     *
     * @param batch
     * @return
     */
    public int batchInsertWmsWarehouseExtItem(List<WmsWarehouseExtItem> batch);

    int loadWaybill(Long waybillId,WmsWarehouseExtItem wmsWarehouseExtItem);

    int batchUpdateWarehouseExtItemStatus(List<Long> itemId,String status);
}
