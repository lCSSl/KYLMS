package com.kaiyu56.wms.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.kaiyu56.common.core.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kaiyu56.wms.domain.WmsWarehouseExtItem;
import com.kaiyu56.wms.service.IWmsWarehouseExtItemService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 仓库拓展-仓库方格信息Controller
 *
 * @author css
 * @date 2021-03-24
 */
@RestController
@RequestMapping("/WmsWarehouseExtItem")
public class WmsWarehouseExtItemController extends BaseController {
    @Autowired
    private IWmsWarehouseExtItemService wmsWarehouseExtItemService;

    /**
     * 查询仓库拓展-仓库方格信息列表
     */
    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:list")
    @GetMapping("/list")
    public AjaxResult list(WmsWarehouseExtItem wmsWarehouseExtItem) {
        if (StringUtils.isNull(wmsWarehouseExtItem.getWarehouseId())) {
            return AjaxResult.success(tableDataInfo(wmsWarehouseExtItem));
        }
        return AjaxResult.success(wmsWarehouseExtItemService.selectWmsWarehouseExtItemMap(wmsWarehouseExtItem));
    }

    private TableDataInfo tableDataInfo(WmsWarehouseExtItem wmsWarehouseExtItem) {
        startPage();
        List<WmsWarehouseExtItem> list = wmsWarehouseExtItemService.selectWmsWarehouseExtItemList(wmsWarehouseExtItem);
        return getDataTable(list);
    }

    /**
     * 导出仓库拓展-仓库方格信息列表
     */
    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:export")
    @Log(title = "仓库拓展-仓库方格信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWarehouseExtItem wmsWarehouseExtItem) throws IOException {
        List<WmsWarehouseExtItem> list = wmsWarehouseExtItemService.selectWmsWarehouseExtItemList(wmsWarehouseExtItem);
        ExcelUtil<WmsWarehouseExtItem> util = new ExcelUtil<WmsWarehouseExtItem>(WmsWarehouseExtItem.class);
        util.exportExcel(response, list, "WmsWarehouseExtItem");
    }

    /**
     * 获取仓库拓展-仓库方格信息详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:query")
    @GetMapping(value = "/{itemId}")
    public AjaxResult getInfo(@PathVariable("itemId") Long itemId) {
        return AjaxResult.success(wmsWarehouseExtItemService.selectWmsWarehouseExtItemById(itemId));
    }

    /**
     * 获取仓库拓展-仓库方格信息详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:query")
    @GetMapping(value = "/getInfo")
    public AjaxResult getInfo(WmsWarehouseExtItem wmsWarehouseExtItem) {
        return AjaxResult.success(wmsWarehouseExtItemService.selectWmsWarehouseExtItemByXY(wmsWarehouseExtItem));
    }

    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:query")
    @GetMapping(value = "/getWaybillInfo/{itemId}")
    public AjaxResult getWaybillInfo(@PathVariable("itemId") Long itemId) {
        return AjaxResult.success(wmsWarehouseExtItemService.selectWmsWaybillInfoByItemId(itemId));
    }

    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:query")
    @GetMapping(value = "/getWaybillId/{itemId}")
    public AjaxResult getWaybillId(@PathVariable("itemId") Long itemId) {
        return AjaxResult.success(wmsWarehouseExtItemService.selectWmsWaybillInfoByItemId(itemId));
    }

    /**
     * 新增仓库拓展-仓库方格信息
     */
    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:add")
    @Log(title = "仓库拓展-仓库方格信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWarehouseExtItem wmsWarehouseExtItem) {
        return toAjax(wmsWarehouseExtItemService.insertWmsWarehouseExtItem(wmsWarehouseExtItem));
    }

    /**
     * 修改仓库拓展-仓库方格信息
     */
    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:edit")
    @Log(title = "仓库拓展-仓库方格信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWarehouseExtItem wmsWarehouseExtItem) {
        return toAjax(wmsWarehouseExtItemService.updateWmsWarehouseExtItem(wmsWarehouseExtItem));
    }

    /**
     * 删除仓库拓展-仓库方格信息
     */
    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:remove")
    @Log(title = "仓库拓展-仓库方格信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{itemIds}")
    public AjaxResult remove(@PathVariable Long[] itemIds) {
        return toAjax(wmsWarehouseExtItemService.deleteWmsWarehouseExtItemByIds(itemIds));
    }

    /**
     * 装载方格
     */
    @PreAuthorize(hasPermi = "wms:WmsWarehouseExtItem:edit")
    @Log(title = "仓库拓展-仓库方格信息", businessType = BusinessType.UPDATE)
    @PutMapping("/loadWaybill/{waybillId}")
    public AjaxResult loadWaybill(@PathVariable Long waybillId, @RequestBody WmsWarehouseExtItem wmsWarehouseExtItem) {
        return toAjax(wmsWarehouseExtItemService.loadWaybill(waybillId,wmsWarehouseExtItem));
    }


}
