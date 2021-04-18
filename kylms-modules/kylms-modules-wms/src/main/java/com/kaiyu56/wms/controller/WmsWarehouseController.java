package com.kaiyu56.wms.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.kaiyu56.common.core.utils.SecurityUtils;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.web.page.TableDataInfo;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.system.api.RemoteUserService;
import com.kaiyu56.system.api.domain.SysDept;
import com.kaiyu56.system.api.model.LoginUser;
import com.kaiyu56.wms.api.domain.WmsWarehouse;
import com.kaiyu56.wms.api.domain.vo.WmsWarehouseVO;
import com.kaiyu56.wms.service.IWmsWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 站点(仓库)信息Controller
 *
 * @author css
 * @date 2021-03-22
 */
@RestController
@RequestMapping("/warehouse")
public class WmsWarehouseController extends BaseController {
    @Autowired
    private IWmsWarehouseService wmsWarehouseService;

    @Autowired
    private RemoteUserService remoteUserService;


    /**
     * 查询站点(仓库)信息列表
     */
    @PreAuthorize(hasPermi = "wms:warehouse:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsWarehouse wmsWarehouse) {
        startPage();
        List<WmsWarehouse> list = wmsWarehouseService.selectWmsWarehouseList(wmsWarehouse);
        return getDataTable(list);
    }

    /**
     * 查询站点(仓库)信息列表
     */
    @PreAuthorize(hasPermi = "wms:warehouse:list")
    @GetMapping("/list/vo")
    public TableDataInfo listVO(WmsWarehouse wmsWarehouse) {
        startPage();
        List<WmsWarehouseVO> list = wmsWarehouseService.selectWmsWarehouseVOList(wmsWarehouse);
        return getDataTable(list);
    }

    /**
     * 导出站点(仓库)信息列表
     */
    @PreAuthorize(hasPermi = "wms:warehouse:export")
    @Log(title = "站点(仓库)信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsWarehouse wmsWarehouse) throws IOException {
        List<WmsWarehouseVO> list = wmsWarehouseService.selectWmsWarehouseVOList(wmsWarehouse);
        ExcelUtil<WmsWarehouseVO> util = new ExcelUtil<>(WmsWarehouseVO.class);
        util.exportExcel(response, list, "warehouse");
    }

    /**
     * 获取站点(仓库)信息详细信息
     */
    @PreAuthorize(hasPermi = "wms:warehouse:query")
    @GetMapping(value = "/{warehouseId}")
    public AjaxResult getInfo(@PathVariable("warehouseId") Long warehouseId) {
        return AjaxResult.success(wmsWarehouseService.selectWmsWarehouseById(warehouseId));
    }

    /**
     * 新增站点(仓库)信息
     */
    @PreAuthorize(hasPermi = "wms:warehouse:add")
    @Log(title = "站点(仓库)信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsWarehouse wmsWarehouse) {
        return toAjax(wmsWarehouseService.insertWmsWarehouse(wmsWarehouse));
    }

    /**
     * 修改站点(仓库)信息
     */
    @PreAuthorize(hasPermi = "wms:warehouse:edit")
    @Log(title = "站点(仓库)信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsWarehouse wmsWarehouse) {
        return toAjax(wmsWarehouseService.updateWmsWarehouse(wmsWarehouse));
    }

    /**
     * 删除站点(仓库)信息
     */
    @PreAuthorize(hasPermi = "wms:warehouse:remove")
    @Log(title = "站点(仓库)信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{warehouseIds}")
    public AjaxResult remove(@PathVariable Long[] warehouseIds) {
        return toAjax(wmsWarehouseService.deleteWmsWarehouseByIds(warehouseIds));
    }

    /**
     * 获取站点(仓库)负责人信息
     */
    @PreAuthorize(hasPermi = "wms:warehouse:query")
    @GetMapping(value = "/getInChargeList")
    public AjaxResult getInChargeList() {
        List<Long> userIds = wmsWarehouseService.selectAllWmsWarehouseInChargeIdList();
        Long[] objects = userIds.stream().toArray(Long[]::new);
        return AjaxResult.success(remoteUserService.selectByIds(objects).getData());
    }

    /**
     * 初始化站点(仓库)方格
     */
    @PreAuthorize(hasPermi = "wms:warehouse:remove")
    @PostMapping(value = "/initWarehouseExtItem/{warehouseId}/{dictCode}/{trayType}/{trayInterval}")
    public AjaxResult initWarehouseExtItem(@PathVariable("warehouseId") Long warehouseId,
                                           @PathVariable("dictCode") Long dictCode,
                                           @PathVariable("trayType") String trayType,
                                           @PathVariable("trayInterval") BigDecimal trayInterval) {

        return AjaxResult.success(wmsWarehouseService.initWmsWarehouseExtItem(warehouseId, dictCode, trayType, trayInterval));
    }
    /**
     * 查询默认站点
     */
    @GetMapping(value = "/getDefaultWarehouse")
    public AjaxResult getDefaultWarehouse() {
        return AjaxResult.success( wmsWarehouseService.selectDefaultWmsWarehouse());
    }
}
