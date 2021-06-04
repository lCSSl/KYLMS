package com.kaiyu56.system.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@ConfigurationProperties("alipay")
public class AlipayProperties {
    private String app_id = "";
    private String merchant_private_key = "";
    private String alipay_public_key = "";
    private String notify_url = "";
    private String return_url = "";
    private String sign_type = "RSA2";
    private String charset = "utf-8";
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

}