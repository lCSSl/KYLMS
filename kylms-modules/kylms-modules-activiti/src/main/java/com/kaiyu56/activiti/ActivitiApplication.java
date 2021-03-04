package com.kaiyu56.activiti;

import com.kaiyu56.common.security.annotation.EnableCustomConfig;
import com.kaiyu56.common.security.annotation.EnableRyFeignClients;
import com.kaiyu56.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 代码生成
 *
 * @author css
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class ActivitiApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ActivitiApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);
    }
}