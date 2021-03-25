package com.kaiyu56.system.api;

import com.kaiyu56.common.core.constant.ServiceNameConstants;
import com.kaiyu56.common.core.domain.R;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.system.api.domain.SysDictData;
import com.kaiyu56.system.api.domain.SysUser;
import com.kaiyu56.system.api.factory.RemoteDictFallbackFactory;
import com.kaiyu56.system.api.factory.RemoteUserFallbackFactory;
import com.kaiyu56.system.api.model.LoginUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 用户服务
 *
 * @author css
 */
@FeignClient(contextId = "remoteDictService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteDictFallbackFactory.class)
public interface RemoteDictService {
    /**
     * 查询字典数据详细
     */
    @GetMapping(value = "/dict/data/{dictCode}")
    R<SysDictData> getInfo(@PathVariable("dictCode") Long dictCode);
}
