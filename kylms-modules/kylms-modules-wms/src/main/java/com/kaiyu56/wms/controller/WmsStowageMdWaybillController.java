package com.kaiyu56.wms.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.kaiyu56.wms.domain.WmsStowageRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.kaiyu56.wms.domain.WmsStowageMdWaybill;
import com.kaiyu56.wms.service.IWmsStowageMdWaybillService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 配载运单中间关联Controller
 *
 * @author css
 * @date 2021-04-08
 */
@RestController
@RequestMapping("/WmsStowageMdWaybill")
public class WmsStowageMdWaybillController extends BaseController {
    @Autowired
    private IWmsStowageMdWaybillService wmsStowageMdWaybillService;

    /**
     * 查询配载运单中间关联列表
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageMdWaybill:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsStowageMdWaybill wmsStowageMdWaybill) {
        startPage();
        List<WmsStowageMdWaybill> list = wmsStowageMdWaybillService.selectWmsStowageMdWaybillList(wmsStowageMdWaybill);
        return getDataTable(list);
    }

    /**
     * 导出配载运单中间关联列表
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageMdWaybill:export")
    @Log(title = "配载运单中间关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsStowageMdWaybill wmsStowageMdWaybill) throws IOException {
        List<WmsStowageMdWaybill> list = wmsStowageMdWaybillService.selectWmsStowageMdWaybillList(wmsStowageMdWaybill);
        ExcelUtil<WmsStowageMdWaybill> util = new ExcelUtil<WmsStowageMdWaybill>(WmsStowageMdWaybill.class);
        util.exportExcel(response, list, "WmsStowageMdWaybill");
    }

    /**
     * 获取配载运单中间关联详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageMdWaybill:query")
    @GetMapping(value = "/{routeId}")
    public AjaxResult getInfo(@PathVariable("routeId") Long routeId) {
        return AjaxResult.success(wmsStowageMdWaybillService.selectWmsStowageMdWaybillById(routeId));
    }

    /**
     * 新增配载运单中间关联
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageMdWaybill:add")
    @Log(title = "配载运单中间关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsStowageMdWaybill wmsStowageMdWaybill) {
        return toAjax(wmsStowageMdWaybillService.insertWmsStowageMdWaybill(wmsStowageMdWaybill));
    }

    /**
     * 修改配载运单中间关联
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageMdWaybill:edit")
    @Log(title = "配载运单中间关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsStowageMdWaybill wmsStowageMdWaybill) {
        return toAjax(wmsStowageMdWaybillService.updateWmsStowageMdWaybill(wmsStowageMdWaybill));
    }

    /**
     * 删除配载运单中间关联
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageMdWaybill:remove")
    @Log(title = "配载运单中间关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/{routeIds}")
    public AjaxResult remove(@PathVariable Long[] routeIds) {
        return toAjax(wmsStowageMdWaybillService.deleteWmsStowageMdWaybillByIds(routeIds));
    }
    /**
     * 删除配载运单中间关联
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageMdWaybill:remove")
    @Log(title = "配载运单中间关联", businessType = BusinessType.DELETE)
    @DeleteMapping("/delWaybillFormRoute/{waybillIds}")
    public AjaxResult delWaybillFormRoute(@PathVariable("waybillIds") Long[] waybillIds) {
        return toAjax(wmsStowageMdWaybillService.deleteWaybillFormRoute(waybillIds));
    }

    /**
     * 删除配载运单中间关联
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageMdWaybill:add")
    @Log(title = "配载运单关联", businessType = BusinessType.INSERT)
    @PostMapping("/makeStowage/{routeId}/{waybillIds}")
    public AjaxResult makeStowage(@PathVariable("routeId")  Long routeId,@PathVariable("waybillIds") Long[] waybillIds) {
        return toAjax(wmsStowageMdWaybillService.makeStowage(routeId,waybillIds));
    }
}
