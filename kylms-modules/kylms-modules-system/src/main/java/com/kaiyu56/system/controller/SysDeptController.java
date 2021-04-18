package com.kaiyu56.system.controller;

import com.kaiyu56.common.core.constant.UserConstants;
import com.kaiyu56.common.core.domain.R;
import com.kaiyu56.common.core.utils.SecurityUtils;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.system.api.domain.SysDept;
import com.kaiyu56.system.service.ISysDeptService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 部门信息
 *
 * @author css
 */
@RestController
@RequestMapping("/dept")
public class SysDeptController extends BaseController {
    @Autowired
    private ISysDeptService deptService;

    /**
     * 获取部门列表
     */
    @PreAuthorize(hasPermi = "system:dept:list")
    @GetMapping("/list")
    public AjaxResult list(SysDept dept) {
        List<SysDept> sysDeptList = deptService.selectDeptList(dept);
        return AjaxResult.success(sysDeptList);
    }
    /**
     * 获取部门列表
     */
    @PreAuthorize(hasPermi = "system:dept:list")
    @GetMapping("/feign/list")
    public R<List<SysDept>> feignList(SysDept dept) {
        List<SysDept> sysDeptList = deptService.selectDeptList(dept);
        return R.ok(sysDeptList);
    }
    /**
     * 查询部门列表（排除节点）
     */
    @PreAuthorize(hasPermi = "system:dept:list")
    @GetMapping("/list/exclude/{deptId}")
    public AjaxResult excludeChild(@PathVariable(value = "deptId", required = false) Long deptId) {
        List<SysDept> sysDeptList = deptService.selectDeptList(new SysDept());
        Iterator<SysDept> it = sysDeptList.iterator();
        while (it.hasNext()) {
            SysDept d = it.next();
            if (d.getDeptId().intValue() == deptId
                    || ArrayUtils.contains(StringUtils.split(d.getAncestors(), ","), deptId + "")) {
                it.remove();
            }
        }
        return AjaxResult.success(sysDeptList);
    }

    /**
     * 根据部门编号获取详细信息
     */
    @PreAuthorize(hasPermi = "system:dept:query")
    @GetMapping(value = "/{deptId}")
    public AjaxResult getInfo(@PathVariable Long deptId) {
        return AjaxResult.success(deptService.selectDeptById(deptId));
    }

    /**
     * 根据部门编号获取详细信息
     */
    @PreAuthorize(hasPermi = "system:dept:query")
    @GetMapping(value = "/getName/{deptId}")
    public AjaxResult getDeptName(@PathVariable Long deptId) {
        return AjaxResult.success(deptService.selectDeptById(deptId));
    }

    /**
     * 获取部门下拉树列表
     */
    @GetMapping("/treeSelect")
    public AjaxResult treeSelect(SysDept dept) {
        List<SysDept> base = deptService.selectDeptList(dept);
        Long parentId = dept.getParentId();
        if (parentId != null) {
            String parenIdStr = parentId.toString();
            List<SysDept> sysDeptList = base.stream().filter(item -> item.getAncestors().contains(parenIdStr)).collect(Collectors.toList());
            return AjaxResult.success(deptService.buildDeptTreeSelect(sysDeptList));
        }
        return AjaxResult.success(deptService.buildDeptTreeSelect(base));
    }

    /**
     * 加载对应角色部门列表树
     */
    @GetMapping(value = "/roleDeptTreeSelect/{roleId}")
    public AjaxResult roleDeptTreeSelect(@PathVariable("roleId") Long roleId) {
        List<SysDept> sysDeptList = deptService.selectDeptList(new SysDept());
        AjaxResult ajax = AjaxResult.success();
        ajax.put("checkedKeys", deptService.selectDeptListByRoleId(roleId));
        ajax.put("depts", deptService.buildDeptTreeSelect(sysDeptList));
        return ajax;
    }

    /**
     * 新增部门
     */
    @PreAuthorize(hasPermi = "system:dept:add")
    @Log(title = "部门管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysDept dept) {
        if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept))) {
            return AjaxResult.error("新增部门'" + dept.getDeptName() + "'失败，部门名称已存在");
        }
        dept.setCreateBy(SecurityUtils.getUsername());
        return toAjax(deptService.insertDept(dept));
    }

    /**
     * 修改部门
     */
    @PreAuthorize(hasPermi = "system:dept:edit")
    @Log(title = "部门管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysDept dept) {
        if (UserConstants.NOT_UNIQUE.equals(deptService.checkDeptNameUnique(dept))) {
            return AjaxResult.error("修改部门'" + dept.getDeptName() + "'失败，部门名称已存在");
        } else if (dept.getParentId().equals(dept.getDeptId())) {
            return AjaxResult.error("修改部门'" + dept.getDeptName() + "'失败，上级部门不能是自己");
        } else if (StringUtils.equals(UserConstants.DEPT_DISABLE, dept.getStatus())
                && deptService.selectNormalChildrenDeptById(dept.getDeptId()) > 0) {
            return AjaxResult.error("该部门包含未停用的子部门！");
        }
        dept.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(deptService.updateDept(dept));
    }

    /**
     * 删除部门
     */
    @PreAuthorize(hasPermi = "system:dept:remove")
    @Log(title = "部门管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deptId}")
    public AjaxResult remove(@PathVariable Long deptId) {
        if (deptService.hasChildByDeptId(deptId)) {
            return AjaxResult.error("存在下级部门,不允许删除");
        }
        if (deptService.checkDeptExistUser(deptId)) {
            return AjaxResult.error("部门存在用户,不允许删除");
        }
        return toAjax(deptService.deleteDeptById(deptId));
    }
    /**
     * 查询部门
     */
    @PreAuthorize(hasPermi = "system:dept:list")
    @GetMapping("/count/name/{deptName}")
    public AjaxResult countDeptByName(@PathVariable String deptName) {
        return AjaxResult.success(deptService.countDeptByName(deptName));
    }
}
