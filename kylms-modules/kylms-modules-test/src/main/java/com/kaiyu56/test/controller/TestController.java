package com.kaiyu56.test.controller;

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
import com.kaiyu56.test.domain.Test;
import com.kaiyu56.test.service.ITestService;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.utils.poi.ExcelUtil;
import com.kaiyu56.common.core.web.page.TableDataInfo;

/**
 * 测试Controller
 *
 * @author css
 * @date 2021-02-22
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {
    @Autowired
    private ITestService testService;

    /**
     * 查询测试列表
     */
    @PreAuthorize(hasPermi = "test:test:list")
    @GetMapping("/list")
    public TableDataInfo list(Test test) {
        startPage();
        List<Test> list = testService.selectTestList(test);
        return getDataTable(list);
    }

    /**
     * 导出测试列表
     */
    @PreAuthorize(hasPermi = "test:test:export")
    @Log(title = "测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Test test) throws IOException {
        List<Test> list = testService.selectTestList(test);
        ExcelUtil<Test> util = new ExcelUtil<Test>(Test.class);
        util.exportExcel(response, list, "test");
    }

    /**
     * 获取测试详细信息
     */
    @PreAuthorize(hasPermi = "test:test:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(testService.getById(id));
    }

    /**
     * 新增测试
     */
    @PreAuthorize(hasPermi = "test:test:add")
    @Log(title = "测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Test test) {
        return toAjax(testService.save(test) ? 1 : 0);
    }

    /**
     * 修改测试
     */
    @PreAuthorize(hasPermi = "test:test:edit")
    @Log(title = "测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Test test) {
        return toAjax(testService.saveOrUpdate(test) ? 1 : 0);
    }

    /**
     * 删除测试
     */
    @PreAuthorize(hasPermi = "test:test:remove")
    @Log(title = "测试", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable List<Long> ids) {
        return toAjax(testService.removeByIds(ids) ? 1 : 0);
    }
}
