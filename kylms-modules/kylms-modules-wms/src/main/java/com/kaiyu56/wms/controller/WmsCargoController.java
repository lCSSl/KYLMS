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
import com.kaiyu56.wms.domain.WmsCargo;
import com.kaiyu56.wms.service.IWmsCargoService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 货物Controller
 * 
 * @author css
 * @date 2021-04-01
 */
@RestController
@RequestMapping("/cargo")
public class WmsCargoController extends BaseController {
    @Autowired
    private IWmsCargoService wmsCargoService;

    /**
     * 查询货物列表
     */
    @PreAuthorize(hasPermi = "wms:cargo:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsCargo wmsCargo)
    {
        startPage();
        List<WmsCargo> list = wmsCargoService.selectWmsCargoList(wmsCargo);
        return getDataTable(list);
    }

    /**
     * 导出货物列表
     */
    @PreAuthorize(hasPermi = "wms:cargo:export")
    @Log(title = "货物", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsCargo wmsCargo) throws IOException
    {
        List<WmsCargo> list = wmsCargoService.selectWmsCargoList(wmsCargo);
        ExcelUtil<WmsCargo> util = new ExcelUtil<WmsCargo>(WmsCargo.class);
        util.exportExcel(response, list, "cargo");
    }

    /**
     * 获取货物详细信息
     */
    @PreAuthorize(hasPermi = "wms:cargo:query")
    @GetMapping(value = "/{cargoId}")
    public AjaxResult getInfo(@PathVariable("cargoId") Long cargoId)
    {
        return AjaxResult.success(wmsCargoService.selectWmsCargoById(cargoId));
    }

    /**
     * 新增货物
     */
    @PreAuthorize(hasPermi = "wms:cargo:add")
    @Log(title = "货物", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsCargo wmsCargo)
    {
        return toAjax(wmsCargoService.insertWmsCargo(wmsCargo));
    }

    /**
     * 修改货物
     */
    @PreAuthorize(hasPermi = "wms:cargo:edit")
    @Log(title = "货物", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsCargo wmsCargo)
    {
        return toAjax(wmsCargoService.updateWmsCargo(wmsCargo));
    }

    /**
     * 删除货物
     */
    @PreAuthorize(hasPermi = "wms:cargo:remove")
    @Log(title = "货物", businessType = BusinessType.DELETE)
	@DeleteMapping("/{cargoIds}")
    public AjaxResult remove(@PathVariable Long[] cargoIds)
    {
        return toAjax(wmsCargoService.deleteWmsCargoByIds(cargoIds));
    }
}
