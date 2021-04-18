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
import com.kaiyu56.wms.domain.WmsStowageRoute;
import com.kaiyu56.wms.service.IWmsStowageRouteService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 运单配载线路Controller
 *
 * @author css
 * @date 2021-04-08
 */
@RestController
@RequestMapping("/WmsStowageRoute")
public class WmsStowageRouteController extends BaseController {
    @Autowired
    private IWmsStowageRouteService wmsStowageRouteService;

    /**
     * 查询运单配载线路列表
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageRoute:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsStowageRoute wmsStowageRoute) {
        startPage();
        List<WmsStowageRoute> list = wmsStowageRouteService.selectWmsStowageRouteList(wmsStowageRoute);
        return getDataTable(list);
    }

    /**
     * 导出运单配载线路列表
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageRoute:export")
    @Log(title = "运单配载线路", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsStowageRoute wmsStowageRoute) throws IOException {
        List<WmsStowageRoute> list = wmsStowageRouteService.selectWmsStowageRouteList(wmsStowageRoute);
        ExcelUtil<WmsStowageRoute> util = new ExcelUtil<WmsStowageRoute>(WmsStowageRoute.class);
        util.exportExcel(response, list, "WmsStowageRoute");
    }

    /**
     * 获取运单配载线路详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageRoute:query")
    @GetMapping(value = "/{routeId}")
    public AjaxResult getInfo(@PathVariable("routeId") Long routeId) {
        return AjaxResult.success(wmsStowageRouteService.selectWmsStowageRouteById(routeId));
    }

    /**
     * 新增运单配载线路
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageRoute:add")
    @Log(title = "运单配载线路", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsStowageRoute wmsStowageRoute) {
        return toAjax(wmsStowageRouteService.insertWmsStowageRoute(wmsStowageRoute));
    }

    /**
     * 修改运单配载线路
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageRoute:edit")
    @Log(title = "运单配载线路", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsStowageRoute wmsStowageRoute) {
        return toAjax(wmsStowageRouteService.updateWmsStowageRoute(wmsStowageRoute));
    }

    /**
     * 删除运单配载线路
     */
    @PreAuthorize(hasPermi = "wms:WmsStowageRoute:remove")
    @Log(title = "运单配载线路", businessType = BusinessType.DELETE)
    @DeleteMapping("/{routeIds}")
    public AjaxResult remove(@PathVariable Long[] routeIds) {
        return toAjax(wmsStowageRouteService.deleteWmsStowageRouteById(routeIds[0]));
    }
}
