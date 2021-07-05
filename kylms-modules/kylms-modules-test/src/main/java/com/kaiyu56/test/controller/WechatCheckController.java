package com.kaiyu56.test.controller;

import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.wechat.api.config.WxMpProperties;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.util.crypto.SHA1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 测试Controller
 *
 * @author css
 * @date 2021-02-25
 */
@Slf4j
@RestController
@RequestMapping("/api/wechat")
public class WechatCheckController extends BaseController {

    private final static String WECHAT_TOKEN = "KY56";

    @Autowired
    private WxMpProperties wxMpProperties;

    @RequestMapping(value = "/{appId}/checkServer")
    public void checkServer(@PathVariable("appId") String appId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<WxMpProperties.MpConfig> configs = wxMpProperties.getConfigs();
        WxMpProperties.MpConfig currentConfig = null;

        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        String encryption = "";
        try {
            encryption = SHA1.gen(WECHAT_TOKEN, timestamp, nonce);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error(e.getMessage());
        }
        log.info("wxMpProperties:{}", wxMpProperties);
        log.info("加密:{}", encryption);
        log.info("本身:{}", signature);
        PrintWriter out = response.getWriter();
        if (!encryption.equals(signature)) {
            return;
        }
        out.print(echostr);
        out.close();
    }


    private  <T extends Object> T getElem(List<T> objs, Integer id, Class<?> clazz) {
        try {
            Method getIdFunc = clazz.getMethod("getId");
            for (T obj : objs) {
                Integer rId = (Integer) getIdFunc.invoke(obj);
                if (rId.equals(id)) {
                    return obj;
                }
            }

        } catch (Exception e) {
            LogUtil.LOG_BASE.error("getElem异常", e.getMessage(), e);
        }

        return null;
    }
}
