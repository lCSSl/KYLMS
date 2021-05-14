package com.kaiyu56.wms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaiyu56.common.core.exception.BaseException;
import com.kaiyu56.common.core.utils.DateUtils;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.wms.api.domain.WmsWarehouse;
import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.kaiyu56.wms.domain.WmsWarehouseExtItem;
import com.kaiyu56.wms.domain.WmsWaybillMdWarehouseExtItem;
import com.kaiyu56.wms.enums.WmsExtItemStatus;
import com.kaiyu56.wms.enums.WmsWaybillStatus;
import com.kaiyu56.wms.mapper.WmsWarehouseExtItemMapper;
import com.kaiyu56.wms.service.IWmsWarehouseExtItemService;
import com.kaiyu56.wms.service.IWmsWaybillMdWarehouseExtItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * 仓库拓展-仓库方格信息Service业务层处理
 *
 * @author css
 * @date 2021-03-24
 */
@Slf4j
@Service
public class WmsWarehouseExtItemServiceImpl extends ServiceImpl<WmsWarehouseExtItemMapper, WmsWarehouseExtItem> implements IWmsWarehouseExtItemService {

    @Autowired
    private WmsWarehouseServiceImpl wmsWarehouseService;
    @Autowired
    private WmsWaybillServiceImpl wmsWaybillService;

    @Autowired
    private IWmsWaybillMdWarehouseExtItemService wmsWaybillMdWarehouseExtItemService;

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

    @Override
    public WmsWarehouseExtItem selectWmsWarehouseExtItemByXY(WmsWarehouseExtItem wmsWarehouseExtItem) {
        return baseMapper.selectWmsWarehouseExtItemByXY(wmsWarehouseExtItem);
    }

    @Override
    public WmsWaybill selectWmsWaybillInfoByItemId(Long itemId) {
        List<WmsWaybillMdWarehouseExtItem> mds = wmsWaybillMdWarehouseExtItemService.selectWmsWaybillMdWarehouseExtItemList(new WmsWaybillMdWarehouseExtItem(itemId));

        if (mds.size() <= 0) {
            throw new BaseException("未找到相关记录");
        } else if (mds.size() > 1) {
            log.warn("There are multiple results");
            throw new BaseException("数据有误，请联系管理员");
        }

        WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem = mds.get(0);

        WmsWaybill wmsWaybill = wmsWaybillService.selectWmsWaybillById(wmsWaybillMdWarehouseExtItem.getWaybillId());

        return wmsWaybill;
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
    @Override
    public HashMap<String, Object> selectWmsWarehouseExtItemMap(WmsWarehouseExtItem wmsWarehouseExtItem) {

        WmsWarehouse wmsWarehouse = wmsWarehouseService.selectWmsWarehouseById(wmsWarehouseExtItem.getWarehouseId());
        Long warehouseMaxX = wmsWarehouse.getWarehouseMaxX();
        Long warehouseMaxY = wmsWarehouse.getWarehouseMaxY();
        List<WmsWarehouseExtItem> list = baseMapper.selectWmsWarehouseExtItemList(wmsWarehouseExtItem);
        HashMap<String, Object> map = new HashMap<>(3);
//        List<List<WmsWarehouseExtItem>> a = new ArrayList<>();
//        for (Long y = 0l; y < warehouseMaxY; y++) {
//            Long finalY = y;
//            a.add(list.stream().filter(item -> finalY.equals(item.getItemY())).collect(Collectors.toList()));
//        }
        map.put("x", warehouseMaxX);
        map.put("y", warehouseMaxY);
        map.put("canvasList", list);
        return map;
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

    @Override
    public int loadWaybill(Long waybillId, WmsWarehouseExtItem wmsWarehouseExtItem) {
        if (!(StringUtils.isNotNull(waybillId) && waybillId.compareTo(0L) > 0)) {
            log.error("waybillId is no available:{}", waybillId);
            throw new BaseException("输入信息有误");
        }
        Long itemId = wmsWarehouseExtItem.getItemId();
        if (!(StringUtils.isNotNull(itemId) && itemId.compareTo(0L) > 0)) {
            log.error("wmsWarehouseExtItem is no available:{}", wmsWarehouseExtItem);
            throw new BaseException("输入信息有误");
        }
        int i = wmsWaybillMdWarehouseExtItemService.insertWmsWaybillMdWarehouseExtItem(new WmsWaybillMdWarehouseExtItem(itemId, waybillId));
        if (i != 1) {
            log.error("wmsWaybillMdWarehouseExtItemService.insertWmsWaybillMdWarehouseExtItem Affect Rows:{}", i);
            throw new BaseException();
        }
        wmsWarehouseExtItem.setStatus(WmsExtItemStatus.LOAD.getCode());
        updateWmsWarehouseExtItem(wmsWarehouseExtItem);
        WmsWaybill wmsWaybill = wmsWaybillService.selectWmsWaybillById(waybillId);
        String waybillStatus = wmsWaybill.getWaybillStatus();
        if (WmsWaybillStatus.NEW.getCode().equals(waybillStatus)) {
            return wmsWaybillService.saveOrUpdate(new WmsWaybill(waybillId, WmsWaybillStatus.WAREHOUSING.getCode())) ? 1 : 0;
        }
        if (WmsWaybillStatus.ARRIVAL.getCode().equals(waybillStatus)) {
            return wmsWaybillService.saveOrUpdate(new WmsWaybill(waybillId, WmsWaybillStatus.ARRIVAL_WAREHOUSING.getCode())) ? 1 : 0;
        }
        return 0;
    }

    @Override
    public int batchUpdateWarehouseExtItemStatus(List<Long> itemIds, String status) {
        return baseMapper.batchUpdateWarehouseExtItemStatus(itemIds,status);
    }
}
