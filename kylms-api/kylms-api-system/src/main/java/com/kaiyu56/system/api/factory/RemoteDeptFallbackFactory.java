package com.kaiyu56.system.api.factory;

import com.kaiyu56.common.core.domain.R;
import com.kaiyu56.system.api.RemoteDeptService;
import com.kaiyu56.system.api.RemoteUserService;
import com.kaiyu56.system.api.domain.SysDept;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户服务降级处理
 *
 * @author css
 */
@Component
public class RemoteDeptFallbackFactory implements FallbackFactory<RemoteDeptService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteDeptFallbackFactory.class);

    @Override
    public RemoteDeptService create(Throwable throwable) {

        return new RemoteDeptService() {
            @Override
            public R<List<SysDept>> feignList(SysDept dept) {
                return R.fail("获取列表失败:" + throwable.getMessage());
            }
        };
    }
}
