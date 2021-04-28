package com.kaiyu56.wms.controller;

import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.web.page.TableDataInfo;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.wms.domain.WmsStowage;
import com.kaiyu56.wms.service.IWmsStowageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 运单配载Controller
 *
 * @author css
 * @date 2021-04-08
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
    public TableDataInfo list(WmsStowage wmsStowage) {
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
    public void export(HttpServletResponse response, WmsStowage wmsStowage) throws IOException {
        List<WmsStowage> list = wmsStowageService.selectWmsStowageList(wmsStowage);
        ExcelUtil<WmsStowage> util = new ExcelUtil<WmsStowage>(WmsStowage.class);
        util.exportExcel(response, list, "WmsStowage");
    }

    /**
     * 获取运单配载详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:query")
    @GetMapping(value = "/{stowageId}")
    public AjaxResult getInfo(@PathVariable("stowageId") Long stowageId) {
        return AjaxResult.success(wmsStowageService.selectWmsStowageById(stowageId));
    }

    /**
     * 新增运单配载
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:add")
    @Log(title = "运单配载", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Map<String, Object> map) {
        return AjaxResult.success(wmsStowageService.insertWmsStowage(map));
    }

    /**
     * 修改运单配载
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:edit")
    @Log(title = "运单配载", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsStowage wmsStowage) {
        return toAjax(wmsStowageService.updateWmsStowage(wmsStowage));
    }

    /**
     * 删除运单配载
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:remove")
    @Log(title = "运单配载", businessType = BusinessType.DELETE)
    @DeleteMapping("/{stowageIds}")
    public AjaxResult remove(@PathVariable Long[] stowageIds) {
        if (stowageIds.length == 1) {
            return toAjax(wmsStowageService.deleteWmsStowageById(stowageIds[0]));
        }
        return toAjax(wmsStowageService.deleteWmsStowageByIds(stowageIds));
    }

    /**
     * 运单配载结束
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:edit")
    @Log(title = "运单配载", businessType = BusinessType.UPDATE)
    @PostMapping("/endStowage/{stowageId}")
    public AjaxResult endStowage(@PathVariable Long stowageId) {

        return toAjax(wmsStowageService.endStowage(stowageId));
    }

    /**
     * 预发车！
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:edit")
    @Log(title = "运单配载", businessType = BusinessType.UPDATE)
    @PostMapping("/preDeparture/{stowageId}")
    public AjaxResult preDeparture(@PathVariable Long stowageId) {
        return toAjax(wmsStowageService.preDeparture(stowageId));
    }

    /**
     * 发车！
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:edit")
    @Log(title = "运单配载", businessType = BusinessType.UPDATE)
    @PostMapping("/departure/{stowageId}")
    public AjaxResult departure(@PathVariable Long stowageId) {
        return toAjax(wmsStowageService.departure(stowageId));
    }

    /**
     * 获取司机任务
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:query")
    @GetMapping("/getDriverMission/{missionStatus}")
    public AjaxResult getDriverMission(@PathVariable String missionStatus) {
        return AjaxResult.success(wmsStowageService.getDriverMission(missionStatus));
    }

    /**
     * 获取司机任务
     */
    @PreAuthorize(hasPermi = "wms:WmsStowage:query")
    @GetMapping("/checkDriverMission/{missionStatus}")
    public AjaxResult checkDriverMission(@PathVariable String missionStatus) {
        return AjaxResult.success(wmsStowageService.checkDriverMission(missionStatus));
    }
}
