package com.kaiyu56.system.controller;

import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.web.page.TableDataInfo;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.system.domain.SysArea;
import com.kaiyu56.system.service.ISysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 行政区Controller
 *
 * @author css
 * @date 2021-03-20
 */
@RestController
@RequestMapping("/area")
public class SysAreaController extends BaseController {
    @Autowired
    private ISysAreaService sysAreaService;

    /**
     * 查询行政区列表
     */
    @PreAuthorize(hasPermi = "system:area:list")
    @GetMapping("/list")
    public TableDataInfo list(SysArea sysArea) {
        startPage();
        List<SysArea> list = sysAreaService.selectSysAreaList(sysArea);
        return getDataTable(list);
    }

    /**
     * 导出行政区列表
     */
    @PreAuthorize(hasPermi = "system:area:export")
    @Log(title = "行政区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysArea sysArea) throws IOException {
        List<SysArea> list = sysAreaService.selectSysAreaList(sysArea);
        ExcelUtil<SysArea> util = new ExcelUtil<SysArea>(SysArea.class);
        util.exportExcel(response, list, "area");
    }

    /**
     * 获取行政区详细信息
     */
    @PreAuthorize(hasPermi = "system:area:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(sysAreaService.selectSysAreaById(id));
    }

    /**
     * 查询行政区单个树
     *
     * @param code 行政区code
     * @return 行政区
     */
    @PreAuthorize(hasPermi = "system:area:query")
    @GetMapping(value = "/findTree/{code}")
    public AjaxResult getTree(@PathVariable("code") Long code) {
        return AjaxResult.success(sysAreaService.selectSysAreaTree(code));
    }

    /**
     * 新增行政区
     */
    @PreAuthorize(hasPermi = "system:area:add")
    @Log(title = "行政区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysArea sysArea) {
        return toAjax(sysAreaService.insertSysArea(sysArea));
    }

    /**
     * 修改行政区
     */
    @PreAuthorize(hasPermi = "system:area:edit")
    @Log(title = "行政区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysArea sysArea) {
        return toAjax(sysAreaService.updateSysArea(sysArea));
    }

    /**
     * 删除行政区
     */
    @PreAuthorize(hasPermi = "system:area:remove")
    @Log(title = "行政区", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysAreaService.deleteSysAreaByIds(ids));
    }
}
