package com.kaiyu56.system.controller.wx;

import com.kaiyu56.common.core.utils.SignUtils;
import com.kaiyu56.common.core.web.controller.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author cssly
 * @date 2021/5/10
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/wx")
public class WechatTestController extends BaseController {

    private static String WECHAT_TOKEN = "kylms";

    @RequestMapping(value = "/getWechatToken")
    public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String value = request.getParameter(name);
            // out.print(name + "=" + value);
            log.error("name =" + name + "     value =" + value);
        }

        String signature = request.getParameter("signature");/// 微信加密签名
        String timestamp = request.getParameter("timestamp");/// 时间戳
        String nonce = request.getParameter("nonce"); /// 随机数
        String echostr = request.getParameter("echostr"); // 随机字符串
        PrintWriter out = response.getWriter();

        if (SignUtils.checkSignature(signature, timestamp, nonce)) {
            out.print(echostr);
        }
        out.close();
    }
}
