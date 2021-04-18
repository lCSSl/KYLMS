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
import com.kaiyu56.wms.domain.WmsVehicle;
import com.kaiyu56.wms.service.IWmsVehicleService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 运输工具信息主Controller
 *
 * @author css
 * @date 2021-03-24
 */
@RestController
@RequestMapping("/WmsVehicle")
public class WmsVehicleController extends BaseController {
    @Autowired
    private IWmsVehicleService wmsVehicleService;

    /**
     * 查询运输工具信息主列表
     */
    @PreAuthorize(hasPermi = "wms:WmsVehicle:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsVehicle wmsVehicle) {
        startPage();
        List<WmsVehicle> list = wmsVehicleService.selectWmsVehicleList(wmsVehicle);
        return getDataTable(list);
    }

    /**
     * 导出运输工具信息主列表
     */
    @PreAuthorize(hasPermi = "wms:WmsVehicle:export")
    @Log(title = "运输工具信息主", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsVehicle wmsVehicle) throws IOException {
        List<WmsVehicle> list = wmsVehicleService.selectWmsVehicleList(wmsVehicle);
        ExcelUtil<WmsVehicle> util = new ExcelUtil<WmsVehicle>(WmsVehicle.class);
        util.exportExcel(response, list, "WmsVehicle");
    }

    /**
     * 获取运输工具信息主详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsVehicle:query")
    @GetMapping(value = "/{vehicleId}")
    public AjaxResult getInfo(@PathVariable("vehicleId") Long vehicleId) {
        return AjaxResult.success(wmsVehicleService.selectWmsVehicleById(vehicleId));
    }

    /**
     * 新增运输工具信息主
     */
    @PreAuthorize(hasPermi = "wms:WmsVehicle:add")
    @Log(title = "运输工具信息主", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsVehicle wmsVehicle) {
        return toAjax(wmsVehicleService.insertWmsVehicle(wmsVehicle));
    }

    /**
     * 修改运输工具信息主
     */
    @PreAuthorize(hasPermi = "wms:WmsVehicle:edit")
    @Log(title = "运输工具信息主", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsVehicle wmsVehicle) {
        return toAjax(wmsVehicleService.updateWmsVehicle(wmsVehicle));
    }

    /**
     * 删除运输工具信息主
     */
    @PreAuthorize(hasPermi = "wms:WmsVehicle:remove")
    @Log(title = "运输工具信息主", businessType = BusinessType.DELETE)
    @DeleteMapping("/{vehicleIds}")
    public AjaxResult remove(@PathVariable Long[] vehicleIds) {
        return toAjax(wmsVehicleService.deleteWmsVehicleByIds(vehicleIds));
    }

    /**
     * 获取车辆定位
     */
    @PreAuthorize(hasPermi = "wms:WmsVehicle:query")
    @GetMapping("/getLocationById/{vehicleId}")
    public AjaxResult getLocationById(@PathVariable Long vehicleId) {
        return AjaxResult.success(wmsVehicleService.getLocationById(vehicleId));
    }
}
