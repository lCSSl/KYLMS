package com.kaiyu56.wms.controller;

import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.web.page.TableDataInfo;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.wms.api.domain.WmsCargoTemp;
import com.kaiyu56.wms.service.IWmsCargoTempService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * 运单货物临时表Controller
 *
 * @author css
 * @date 2021-04-01
 */
@Slf4j
@RestController
@RequestMapping("/WmsCargoTemp")
public class WmsCargoTempController extends BaseController {
    @Autowired
    private IWmsCargoTempService wmsCargoTempService;

    /**
     * 查询运单货物临时表列表
     */
    @PreAuthorize(hasPermi = "wms:WmsCargoTemp:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsCargoTemp wmsCargoTemp) {
        startPage();
        List<WmsCargoTemp> list = wmsCargoTempService.selectWmsCargoTempList(wmsCargoTemp);
        return getDataTable(list);
    }

    /**
     * 导出运单货物临时表列表
     */
    @PreAuthorize(hasPermi = "wms:WmsCargoTemp:export")
    @Log(title = "运单货物临时表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsCargoTemp wmsCargoTemp) throws IOException {
        List<WmsCargoTemp> list = wmsCargoTempService.selectWmsCargoTempList(wmsCargoTemp);
        ExcelUtil<WmsCargoTemp> util = new ExcelUtil<WmsCargoTemp>(WmsCargoTemp.class);
        util.exportExcel(response, list, "WmsCargoTemp");
    }

    /**
     * 获取运单货物临时表详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsCargoTemp:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(wmsCargoTempService.selectWmsCargoTempById(id));
    }

    /**
     * 新增运单货物临时表
     */
    @PreAuthorize(hasPermi = "wms:WmsCargoTemp:add")
    @Log(title = "运单货物临时表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsCargoTemp wmsCargoTemp) {

        return toAjax(wmsCargoTempService.insertWmsCargoTemp(wmsCargoTemp));
    }

    /**
     * 新增运单货物临时表
     */
    @PreAuthorize(hasPermi = "wms:WmsCargoTemp:add")
    @Log(title = "运单货物临时表", businessType = BusinessType.INSERT)
    @PostMapping("/batch")
    public AjaxResult addBatch(@RequestBody Set<WmsCargoTemp> wmsCargoTempSet) {
        return toAjax(wmsCargoTempService.insertWmsCargoTempBatch(wmsCargoTempSet));
    }

    /**
     * 修改运单货物临时表
     */
    @PreAuthorize(hasPermi = "wms:WmsCargoTemp:edit")
    @Log(title = "运单货物临时表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsCargoTemp wmsCargoTemp) {
        return toAjax(wmsCargoTempService.updateWmsCargoTemp(wmsCargoTemp));
    }

    /**
     * 删除运单货物临时表
     */
    @PreAuthorize(hasPermi = "wms:WmsCargoTemp:remove")
    @Log(title = "运单货物临时表", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(wmsCargoTempService.deleteWmsCargoTempByIds(ids));
    }
}
