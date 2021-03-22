package com.kaiyu56.system.api.factory;

import com.kaiyu56.common.core.domain.R;
import com.kaiyu56.system.api.RemoteUserService;
import com.kaiyu56.system.api.domain.SysUser;
import com.kaiyu56.system.api.model.LoginUser;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 用户服务降级处理
 *
 * @author css
 */
@Component
public class RemoteUserFallbackFactory implements FallbackFactory<RemoteUserService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteUserFallbackFactory.class);

    @Override
    public RemoteUserService create(Throwable throwable) {
        log.error("用户服务调用失败:{}", throwable.getMessage());
        return new RemoteUserService() {
            @Override
            public R<LoginUser> getUserInfo(String username) {
                return R.fail("获取用户失败:" + throwable.getMessage());
            }

            @Override
            public R<SysUser> selectByIds(Long[] userIds) {
                return R.fail("获取用户列表失败:" + throwable.getMessage());
            }
        };
    }
}
