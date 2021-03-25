package com.kaiyu56.system.api.factory;

import com.kaiyu56.common.core.domain.R;
import com.kaiyu56.system.api.RemoteDictService;
import com.kaiyu56.system.api.RemoteUserService;
import com.kaiyu56.system.api.domain.SysDictData;
import com.kaiyu56.system.api.domain.SysUser;
import com.kaiyu56.system.api.model.LoginUser;
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
public class RemoteDictFallbackFactory implements FallbackFactory<RemoteDictService> {
    private static final Logger log = LoggerFactory.getLogger(RemoteDictFallbackFactory.class);

    @Override
    public RemoteDictService create(Throwable throwable) {
        log.error("服务调用失败:{}", throwable.getMessage());
        return new RemoteDictService() {

            @Override
            public R<SysDictData> getInfo(Long dictCode) {
                return R.fail("获取失败:" + throwable.getMessage());
            }
        };
    }
}
