package com.kaiyu56.test.controller;

import com.kaiyu56.common.core.web.controller.BaseController;
import com.kaiyu56.test.config.WxMpConfiguration;
import com.kaiyu56.test.config.WxMpProperties;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.util.crypto.SHA1;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 测试Controller
 *
 * @author css
 * @date 2021-02-25
 */
@Slf4j
@RestController
@RequestMapping("/api/wechat")
public class TestController extends BaseController{

    private final static String WECHAT_TOKEN = "KY56";

    @Autowired
    private WxMpConfiguration wxMpConfiguration;

    @RequestMapping(value = "/{appId}/checkServer")
    public void checkServer(@PathVariable("appId")String appId, HttpServletRequest request, HttpServletResponse response) throws Exception {
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
        log.info("wxMpConfiguration:{}", wxMpConfiguration);
        log.info("加密:{}", encryption);
        log.info("本身:{}", signature);
        PrintWriter out = response.getWriter();
        if (!encryption.equals(signature)) {
            return;
        }
        out.print(echostr);
        out.close();
    }

}
