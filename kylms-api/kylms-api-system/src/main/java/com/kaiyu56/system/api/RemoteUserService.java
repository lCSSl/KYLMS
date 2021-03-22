package com.kaiyu56.system.api;

import com.kaiyu56.common.core.constant.ServiceNameConstants;
import com.kaiyu56.common.core.domain.R;
import com.kaiyu56.system.api.domain.SysUser;
import com.kaiyu56.system.api.factory.RemoteUserFallbackFactory;
import com.kaiyu56.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户服务
 *
 * @author css
 */
@FeignClient(contextId = "remoteUserService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteUserFallbackFactory.class)
public interface RemoteUserService {
    /**
     * 通过用户名查询用户信息
     *
     * @param username 用户名
     * @return 结果
     */
    @GetMapping(value = "/user/info/{username}")
    public R<LoginUser> getUserInfo(@PathVariable("username") String username);

    /**
     * 根据IDS查询用户列表
     *
     * @param userIds 用户IDS列表
     * @return 用户信息集合信息
     */
    @GetMapping("/list/{userIds}")
    public R<SysUser> selectByIds(@PathVariable("userIds") Long[] userIds);
}
