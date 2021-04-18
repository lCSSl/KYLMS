package com.kaiyu56.system.api;

import com.kaiyu56.common.core.constant.ServiceNameConstants;
import com.kaiyu56.common.core.domain.R;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.system.api.domain.SysDept;
import com.kaiyu56.system.api.domain.SysUser;
import com.kaiyu56.system.api.factory.RemoteDeptFallbackFactory;
import com.kaiyu56.system.api.factory.RemoteUserFallbackFactory;
import com.kaiyu56.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 用户服务
 *
 * @author css
 */
@FeignClient(contextId = "remoteDeptService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteDeptFallbackFactory.class)
public interface RemoteDeptService {

    @GetMapping("/dept/feign/list")
    public R<List<SysDept>> feignList(@RequestParam("dept") SysDept dept);
}
