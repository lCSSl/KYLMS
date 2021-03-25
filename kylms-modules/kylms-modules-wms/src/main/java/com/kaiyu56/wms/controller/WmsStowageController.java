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
import com.kaiyu56.wms.domain.WmsStowage;
import com.kaiyu56.wms.service.IWmsStowageService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 运单配载Controller
 * 
 * @author css
 * @date 2021-03-24
 */
@RestController
@RequestMapping("/WmsStowage")
public class WmsStowageController extends BaseController {
    @Autowired
    private IWmsStowageService wmsStowageService;

    /**
     * 查询运单配载列表
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsStowage wmsStowage)
    {
        startPage();
        List<WmsStowage> list = wmsStowageService.selectWmsStowageList(wmsStowage);
        return getDataTable(list);
    }

    /**
     * 导出运单配载列表
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:export")
    @Log(title = "运单配载", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsStowage wmsStowage) throws IOException
    {
        List<WmsStowage> list = wmsStowageService.selectWmsStowageList(wmsStowage);
        ExcelUtil<WmsStowage> util = new ExcelUtil<WmsStowage>(WmsStowage.class);
        util.exportExcel(response, list, "WmsStowage");
    }

    /**
     * 获取运单配载详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:query")
    @GetMapping(value = "/{stowageId}")
    public AjaxResult getInfo(@PathVariable("stowageId") Long stowageId)
    {
        return AjaxResult.success(wmsStowageService.selectWmsStowageById(stowageId));
    }

    /**
     * 新增运单配载
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:add")
    @Log(title = "运单配载", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsStowage wmsStowage)
    {
        return toAjax(wmsStowageService.insertWmsStowage(wmsStowage));
    }

    /**
     * 修改运单配载
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:edit")
    @Log(title = "运单配载", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsStowage wmsStowage)
    {
        return toAjax(wmsStowageService.updateWmsStowage(wmsStowage));
    }

    /**
     * 删除运单配载
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:remove")
    @Log(title = "运单配载", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stowageIds}")
    public AjaxResult remove(@PathVariable Long[] stowageIds)
    {
        return toAjax(wmsStowageService.deleteWmsStowageByIds(stowageIds));
    }
}
