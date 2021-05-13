package com.kaiyu56.system.controller;

import com.kaiyu56.common.core.constant.CacheConstants;
import com.kaiyu56.common.core.utils.StringUtils;
import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.common.core.web.domain.AjaxResult;
import com.kaiyu56.common.core.web.page.TableDataInfo;
import com.kaiyu56.common.log.annotation.Log;
import com.kaiyu56.common.log.enums.BusinessType;
import com.kaiyu56.common.redis.service.RedisService;
import com.kaiyu56.common.security.annotation.PreAuthorize;
import com.kaiyu56.system.api.model.LoginUser;
import com.kaiyu56.system.domain.SysUserOnline;
import com.kaiyu56.system.service.ISysIndexService;
import com.kaiyu56.system.service.ISysUserOnlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 在线用户监控
 *
 * @author css
 */
@RestController
@RequestMapping("/index")
public class SysIndexController extends BaseController {
    @Autowired
    private ISysIndexService sysIndexService;
    @Autowired
    private RedisService redisService;

    @GetMapping("/count")
    public AjaxResult count() {
        Collection<String> keys = redisService.keys(CacheConstants.LOGIN_TOKEN_KEY + "*");
        Map<String ,Object> map = new HashMap<>(6);
        map.put("onlineUserNumber",keys.size());
        map.put("visitUserWeekNumberBefore",sysIndexService.getVisitUserNumberBefore());
        map.put("visitUserWeekNumberNow",sysIndexService.getVisitUserNumberNow());
        map.put("operWeekNumberBefore",sysIndexService.getOperNumberBefore());
        map.put("operWeekNumberNow",sysIndexService.getOperNumberNow());
        return AjaxResult.success(map);
    }
}
