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
import com.kaiyu56.wms.domain.WmsWaybillExtSettlement;
import com.kaiyu56.wms.service.IWmsWaybillExtSettlementService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 运单拓展信息-费用Controller
 * 
 * @author css
 * @date 2021-03-24
 */
@RestController
@RequestMapping("/WmsWaybillExtSettlement")
public class WmsWaybillExtSettlementController extends BaseController {
    @Autowired
    private IWmsWaybillExtSettlementService wmsWaybillExtSettlementService;

    /**
     * 查询运单拓展信息-费用列表
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillExtSettlement:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsWaybillExtSettlement wmsWaybillExtSettlement)
    {
        startPage();
        List<WmsWaybillExtSettlement> list = wmsWaybillExtSettlementService.selectWmsWaybillExtSettlementList(wmsWaybillExtSettlement);
        return getDataTable(list);
    }

    /**
     * 导出运单拓展信息-费用列表
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillExtSettlement:export")
    @Log(title = "运单拓展信息-费用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWaybillExtSettlement wmsWaybillExtSettlement) throws IOException
    {
        List<WmsWaybillExtSettlement> list = wmsWaybillExtSettlementService.selectWmsWaybillExtSettlementList(wmsWaybillExtSettlement);
        ExcelUtil<WmsWaybillExtSettlement> util = new ExcelUtil<WmsWaybillExtSettlement>(WmsWaybillExtSettlement.class);
        util.exportExcel(response, list, "WmsWaybillExtSettlement");
    }

    /**
     * 获取运单拓展信息-费用详细信息
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillExtSettlement:query")
    @GetMapping(value = "/{wbSettlementId}")
    public AjaxResult getInfo(@PathVariable("wbSettlementId") Long wbSettlementId)
    {
        return AjaxResult.success(wmsWaybillExtSettlementService.selectWmsWaybillExtSettlementById(wbSettlementId));
    }

    /**
     * 新增运单拓展信息-费用
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillExtSettlement:add")
    @Log(title = "运单拓展信息-费用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWaybillExtSettlement wmsWaybillExtSettlement)
    {
        return toAjax(wmsWaybillExtSettlementService.insertWmsWaybillExtSettlement(wmsWaybillExtSettlement));
    }

    /**
     * 修改运单拓展信息-费用
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillExtSettlement:edit")
    @Log(title = "运单拓展信息-费用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWaybillExtSettlement wmsWaybillExtSettlement)
    {
        return toAjax(wmsWaybillExtSettlementService.updateWmsWaybillExtSettlement(wmsWaybillExtSettlement));
    }

    /**
     * 删除运单拓展信息-费用
     */
    @PreAuthorize(hasPermi = "wms:WmsWaybillExtSettlement:remove")
    @Log(title = "运单拓展信息-费用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{wbSettlementIds}")
    public AjaxResult remove(@PathVariable Long[] wbSettlementIds)
    {
        return toAjax(wmsWaybillExtSettlementService.deleteWmsWaybillExtSettlementByIds(wbSettlementIds));
    }
}
