package com.kaiyu56.system.controller.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePayRequest;
import com.alipay.api.response.AlipayTradePayResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping(value = "/api/alipay")
public class AlipayTestController {
    private static String WECHAT_TOKEN = "kylms";

    @Value("${alipay.app_id}")
    private String appId;

    @Value("${alipay.merchant_private_key}")
    private String merchantPrivateKey;

    @RequestMapping(value = "/notify")
    public void notify(HttpServletRequest request, HttpServletResponse response) {
        log.error("request",request);
        log.error("response",response);
    }
    @RequestMapping(value = "/send")
    public void send() {
        AlipayClient alipayClient = new DefaultAlipayClient (
                "https://openapi.alipaydev.com/gateway.do",
                "2021000117669530",
                "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCegG/skUny6dM6Nor4tk89/0TNsRuno31s5ATKwFKaAaSioUQF3Gi0M+1tlx+u4CyGxM/VlOtK8ItsJw8rP1EJHFjpqhMCjKlAs3u4ZD3jhwI6Gxw4UpQ4Sl5NrgwATtk3RvwjKXtOre6luUiBgHXV5W4HgGBMsAngo+DdHvk3v39gqIqjtycQFuWJAPhqj1ug7KfWNq5OxrLf+QOyvu3Gony3TmVLvfT4daA/O4t38Cn1vlDJCTl4ZOUSczOsDuA+LlSko4klOvRphqnH7R+20O+paNBTfAWRH1sfp2IIycWhPgggp4OZ4TrZ8bFnGakNJWho7nnp3qsBhJCkcvQrAgMBAAECggEABC+6RRJVVLAuXxQ/uW//SdDrPU+XPmdIEc83/S71P5IZih4eUNVQgqn4dHOQZ6sOIgUixC5pxJHz7MhfUzIZ7tar1ogidmfGtKnI88baB59yRJygszAjMBVuxjh5oqxyek5KrJcU5bAcZI4vRxRgiGTF8jbG1F+18xQBBXYi+QDwDZ52puAi3w3u+GVxIb49VOIlJF3hverFjzE8GO7zkNT8kXsSqtWpOo+CxLoB95YdmwtbhDZQgLxKjU+w1vPH4wf9bNCrTHhLviRcmcbJ+ETb20KSC0f1H+3J0RoIalUjuKfQwiB97F7tiTtvtLv0JOqtrZcqoyBqT/pllPCwGQKBgQDu2aUQfqY9Cv8GZqfOV7tWQdtppbE9oBdD7IAB26tVVF+oNIH5GnMuOnHkuk3KIo8xjq0Pr6EEpEnVdtyMdDXb4AuuZTVjilwawTPLkLJHgvLRfKb4FVk53bICzK6j6qHB8bluBse1do7L4aMbc1cZhtv7iaDRYrzJ2W+BP+J9lwKBgQCp4ePvqxZGklvABzkkR0ZUeZ4IIiwZAzQFgoOczjIim+J+Xnhl/qooK34jTcxghlGPq/2Add07CFeBiv0enopc1aZaaIe3HAompOgg5PHS3rUiJnuNIsaZb0MV7+gaMzkDkWqo5hNDlYQjhYweIotEajaz9+BVOL385ue4+XN4jQKBgQDQit1RQpNY9vHmH9liEz2xOX0eiBnxqYbGuoalmKvGrA19KqNU4SAx+7uXrobe9z+5UE6QRJM9H0iMBeTZCVpBKSRp11o/F/4FKi1UDnlqcM4b1E9gihtGp+eWBCpzWhhz4t85Ttgt+18AanjkLdedpR8LR4ZPa3tUbfGqkyHo7wKBgGAIyonZ9aW/Zw6PBsZzZFasyaFfb/5TyTy0IyKpjb3y0X8OeJFv/VDoBU5/1GFcjQ7i81ODTaTpek5I+/4rMZx5SqkhHldtCm/+GRs/UVUbgNnlV0LZvdtPAmWMUXE+M6TIt7rzFUDHbQOHo0YF0STDxljGb5K9mOk2vxfaLGShAoGBAL5IOJIzEHtnYPv+dfPaJrVuUEiK9a7hDiyhMQRp055joelfXq4ROU3JAWtyktFqlyiV8FLU0fSKmsfuVs+NAo1WHdY3qgMoYtjkONGfuoKgoVffSm+iJ81RnTwBRaThsB0vJfI6N+WoGypn2AsiEakVPDRmM8eYz+TUoYaPWE17",
                "json","utf-8",
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0f1iG7dBqVOaOnpBiGL0c452UgZWVWKamG27OM+g+a2ebIBlIvJQF0Z4hZW4BD7gCUEp/En5mBIaTTb2hp6iH0D6XGha6wjw9C0s9sn3U7vwciBhyHfqk9Cig0p4wpRGD6RCk7csu1kI55/ZRJUf4tHSnU4JDhODzQvPGrXqSwi0eDB7NmVsp4nPS82O05XUJflUTI7Ckv045byIJUBylYJgkNrClfaK7+ahssA+nlfKVBWMgAz1YGc/cdqLG4FMOysRJuxJpCWF2BBLiMbZuSdTIOUauVx994wacpIzSnNxdDx1UTi8jwuAtEEUbTmUeuDoYBlz9XHWX9QNYbbbvQIDAQAB",
                "RSA2" );
        AlipayTradePayRequest request = new AlipayTradePayRequest();
        AlipayTradePayModel model = new AlipayTradePayModel();
        request.setBizModel(model);
        model.setOutTradeNo(System.currentTimeMillis()+"");
        model.setSubject("Iphone6 16G");
        model.setTotalAmount("0.01");
        model.setAuthCode("xxxxx");//沙箱钱包中的付款码
        model.setScene("bar_code");
        AlipayTradePayResponse response = null;
        try {
            response = alipayClient.execute(request);
            System.out.println(response.getBody());
            System.out.println(response.getTradeNo());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
    }
}
