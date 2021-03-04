package com.kaiyu56.activiti.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;

/**
 * 测试Controller
 *
 * @author css
 * @date 2021-02-25
 */
@RestController
@RequestMapping("/activity")
public class TestController extends BaseController {

    /**
     * 删除测试
     */
    @Log(title = "测试", businessType = BusinessType.DELETE)
    @GetMapping("/test")
    public AjaxResult test() {
        return AjaxResult.success();
    }
}
