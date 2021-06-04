package com.kaiyu56.test.controller;

import com.kaiyu56.common.core.utils.SignUtils;
import com.kaiyu56.common.core.web.controller.BaseController;
import groovy.util.logging.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * 测试Controller
 *
 * @author css
 * @date 2021-02-25
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {
    private static String WECHAT_TOKEN = "KY56";

    @RequestMapping(value = "/getWechatToken")
    public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {

//        Enumeration pNames = request.getParameterNames();
//        while (pNames.hasMoreElements()) {
//            String name = (String) pNames.nextElement();
//            String value = request.getParameter(name);
//            // out.print(name + "=" + value);
//            log.error("name =" + name + "     value =" + value);
//        }
//
//        String signature = request.getParameter("signature");/// 微信加密签名
//        String timestamp = request.getParameter("timestamp");/// 时间戳
//        String nonce = request.getParameter("nonce"); /// 随机数
//        String echostr = request.getParameter("echostr"); // 随机字符串
//        PrintWriter out = response.getWriter();
//
//        if (SignUtils.checkSignature(signature, timestamp, nonce)) {
//            out.print(echostr);
//        }
//        out.close();
    }
}
