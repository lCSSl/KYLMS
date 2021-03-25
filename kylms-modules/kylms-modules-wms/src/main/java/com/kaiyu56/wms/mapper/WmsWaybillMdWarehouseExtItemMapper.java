package com.kaiyu56.wms.mapper;

import java.util.List;
import com.kaiyu56.wms.domain.WmsWaybillMdWarehouseExtItem;

/**
 * 运单-仓库方格中间Mapper接口
 * 
 * @author css
 * @date 2021-03-24
 */
public interface WmsWaybillMdWarehouseExtItemMapper 
{
    /**
     * 查询运单-仓库方格中间
     * 
     * @param id 运单-仓库方格中间ID
     * @return 运单-仓库方格中间
     */
    public WmsWaybillMdWarehouseExtItem selectWmsWaybillMdWarehouseExtItemById(Long id);

    /**
     * 查询运单-仓库方格中间列表
     * 
     * @param wmsWaybillMdWarehouseExtItem 运单-仓库方格中间
     * @return 运单-仓库方格中间集合
     */
    public List<WmsWaybillMdWarehouseExtItem> selectWmsWaybillMdWarehouseExtItemList(WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem);

    /**
     * 新增运单-仓库方格中间
     * 
     * @param wmsWaybillMdWarehouseExtItem 运单-仓库方格中间
     * @return 结果
     */
    public int insertWmsWaybillMdWarehouseExtItem(WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem);

    /**
     * 修改运单-仓库方格中间
     * 
     * @param wmsWaybillMdWarehouseExtItem 运单-仓库方格中间
     * @return 结果
     */
    public int updateWmsWaybillMdWarehouseExtItem(WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem);

    /**
     * 删除运单-仓库方格中间
     * 
     * @param id 运单-仓库方格中间ID
     * @return 结果
     */
    public int deleteWmsWaybillMdWarehouseExtItemById(Long id);

    /**
     * 批量删除运单-仓库方格中间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsWaybillMdWarehouseExtItemByIds(Long[] ids);
}
