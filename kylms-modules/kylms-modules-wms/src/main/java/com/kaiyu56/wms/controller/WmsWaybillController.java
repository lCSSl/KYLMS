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
import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.kaiyu56.wms.service.IWmsWaybillService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 运单信息主Controller
 *
 * @author css
 * @date 2021-03-20
 */
@RestController
@RequestMapping("/waybill")
public class WmsWaybillController extends BaseController {
    @Autowired
    private IWmsWaybillService wmsWaybillService;

/**
 * 查询运单信息主列表
 */
    @PreAuthorize(hasPermi = "wms:waybill:list")
    @GetMapping("/list")
        public TableDataInfo list(WmsWaybill wmsWaybill) {
        startPage();
        List<WmsWaybill> list = wmsWaybillService.selectWmsWaybillList(wmsWaybill);
        return getDataTable(list);
    }
    
    /**
     * 导出运单信息主列表
     */
    @PreAuthorize(hasPermi = "wms:waybill:export")
    @Log(title = "运单信息主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWaybill wmsWaybill) throws IOException {
        List<WmsWaybill> list = wmsWaybillService.selectWmsWaybillList(wmsWaybill);
        ExcelUtil<WmsWaybill> util = new ExcelUtil<WmsWaybill>(WmsWaybill. class);
        util.exportExcel(response, list, "waybill");
    }

    /**
     * 获取运单信息主详细信息
     */
    @PreAuthorize(hasPermi = "wms:waybill:query")
    @GetMapping(value = "/{waybillId}")
    public AjaxResult getInfo(@PathVariable("waybillId") Long waybillId) {
        return AjaxResult.success(wmsWaybillService.getById(waybillId));
    }

    /**
     * 新增运单信息主
     */
    @PreAuthorize(hasPermi = "wms:waybill:add")
    @Log(title = "运单信息主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWaybill wmsWaybill) {
        return toAjax(wmsWaybillService.save(wmsWaybill) ? 1 : 0);
    }

    /**
     * 修改运单信息主
     */
    @PreAuthorize(hasPermi = "wms:waybill:edit")
    @Log(title = "运单信息主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWaybill wmsWaybill) {
        return toAjax(wmsWaybillService.saveOrUpdate(wmsWaybill) ? 1 : 0);
    }

    /**
     * 删除运单信息主
     */
    @PreAuthorize(hasPermi = "wms:waybill:remove")
    @Log(title = "运单信息主", businessType = BusinessType.DELETE)
    @DeleteMapping("/{waybillIds}")
    public AjaxResult remove(@PathVariable List<Long> waybillIds) {
        return toAjax(wmsWaybillService.removeByIds(waybillIds) ? 1 : 0);
    }
}
