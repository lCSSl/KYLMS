package com.kaiyu56.wms.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kaiyu56.wms.domain.WmsWaybillMdWarehouseExtItem;
import com.kaiyu56.wms.service.IWmsWaybillMdWarehouseExtItemService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 运单-仓库方格中间Controller
 * 
 * @author css
 * @date 2021-03-24
 */
@RestController
@RequestMapping("/WmsWaybillMdWarehouseExtItem")
public class WmsWaybillMdWarehouseExtItemController extends BaseController {
    @Autowired
    private IWmsWaybillMdWarehouseExtItemService wmsWaybillMdWarehouseExtItemService;

    /**
     * 查询运单-仓库方格中间列表
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillMdWarehouseExtItem:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem)
    {
        startPage();
        List<WmsWaybillMdWarehouseExtItem> list = wmsWaybillMdWarehouseExtItemService.selectWmsWaybillMdWarehouseExtItemList(wmsWaybillMdWarehouseExtItem);
        return getDataTable(list);
    }

    /**
     * 导出运单-仓库方格中间列表
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillMdWarehouseExtItem:export")
    @Log(title = "运单-仓库方格中间", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem) throws IOException
    {
        List<WmsWaybillMdWarehouseExtItem> list = wmsWaybillMdWarehouseExtItemService.selectWmsWaybillMdWarehouseExtItemList(wmsWaybillMdWarehouseExtItem);
        ExcelUtil<WmsWaybillMdWarehouseExtItem> util = new ExcelUtil<WmsWaybillMdWarehouseExtItem>(WmsWaybillMdWarehouseExtItem.class);
        util.exportExcel(response, list, "WmsWaybillMdWarehouseExtItem");
    }

    /**
     * 获取运单-仓库方格中间详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillMdWarehouseExtItem:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wmsWaybillMdWarehouseExtItemService.selectWmsWaybillMdWarehouseExtItemById(id));
    }

    /**
     * 新增运单-仓库方格中间
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillMdWarehouseExtItem:add")
    @Log(title = "运单-仓库方格中间", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem)
    {
        return toAjax(wmsWaybillMdWarehouseExtItemService.insertWmsWaybillMdWarehouseExtItem(wmsWaybillMdWarehouseExtItem));
    }

    /**
     * 修改运单-仓库方格中间
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillMdWarehouseExtItem:edit")
    @Log(title = "运单-仓库方格中间", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWaybillMdWarehouseExtItem wmsWaybillMdWarehouseExtItem)
    {
        return toAjax(wmsWaybillMdWarehouseExtItemService.updateWmsWaybillMdWarehouseExtItem(wmsWaybillMdWarehouseExtItem));
    }

    /**
     * 删除运单-仓库方格中间
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillMdWarehouseExtItem:remove")
    @Log(title = "运单-仓库方格中间", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsWaybillMdWarehouseExtItemService.deleteWmsWaybillMdWarehouseExtItemByIds(ids));
    }
}
