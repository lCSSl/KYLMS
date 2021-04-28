package com.kaiyu56.wms.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.kaiyu56.common.core.utils.SecurityUtils;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.web.page.TableDataInfo;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.system.api.RemoteDeptService;
import com.kaiyu56.system.api.RemoteUserService;
import com.kaiyu56.system.api.domain.SysUser;
import com.kaiyu56.system.api.model.LoginUser;
import com.kaiyu56.wms.api.domain.WmsWaybill;
import com.kaiyu56.wms.api.domain.vo.WmsWaybillVO;
import com.kaiyu56.wms.service.IWmsWaybillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 运单信息主Controller
 *
 * @author css
 * @date 2021-03-20
 */
@Slf4j
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
     * 查询运单信息主列表
     */
    @PreAuthorize(hasPermi = "wms:waybill:list")
    @GetMapping("/list/vo")
    public TableDataInfo voList(WmsWaybillVO vo) {
        startPage();
        List<WmsWaybillVO> list = wmsWaybillService.selectWmsWaybillVOList(vo);
        return getDataTable(list);
    }

    /**
     * 查询运单信息主列表
     */
    @PreAuthorize(hasPermi = "wms:waybill:list")
    @GetMapping("/list/vo/{routeId}")
    public TableDataInfo voList(@PathVariable("routeId") Long routeId) {
        startPage();
        List<WmsWaybillVO> list = wmsWaybillService.selectWmsWaybillVOList(routeId);
        return getDataTable(list);
    }

    /**
     * 导出运单信息主列表
     */
    @PreAuthorize(hasPermi = "wms:waybill:export")
    @Log(title = "运单信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWaybillVO vo) throws IOException {
        List<WmsWaybillVO> list = wmsWaybillService.selectWmsWaybillVOList(vo);
        ExcelUtil<WmsWaybillVO> util = new ExcelUtil<>(WmsWaybillVO.class);
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
    @Log(title = "运单信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWaybill wmsWaybill) {
        wmsWaybillService.insertWmsWaybill(wmsWaybill);
        return AjaxResult.success(wmsWaybill);
    }

    /**
     * 修改运单信息主
     */
    @PreAuthorize(hasPermi = "wms:waybill:edit")
    @Log(title = "运单信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWaybill wmsWaybill) {
        return AjaxResult.success(wmsWaybillService.updateWmsWaybill(wmsWaybill));
    }

    /**
     * 删除运单信息主
     */
    @PreAuthorize(hasPermi = "wms:waybill:remove")
    @Log(title = "运单信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{waybillIds}")
    public AjaxResult remove(@PathVariable List<Long> waybillIds) {
        return toAjax(wmsWaybillService.removeByIds(waybillIds) ? 1 : 0);
    }

    /**
     * 获取打印信息
     */
    @PreAuthorize(hasPermi = "wms:waybill:query")
    @Log(title = "运单信息", businessType = BusinessType.DELETE)
    @GetMapping("/getPrintData/{waybillId}")
    public AjaxResult getPrintData(@PathVariable Long waybillId) {
        return AjaxResult.success(wmsWaybillService.getPrintData(waybillId));
    }
}
