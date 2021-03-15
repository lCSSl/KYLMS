package com.kaiyu56.job;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.kaiyu56.common.security.annotation.EnableCustomConfig;
import com.kaiyu56.common.security.annotation.EnableBaseFeignClients;
import com.kaiyu56.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 *
 * @author css
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableBaseFeignClients
@SpringCloudApplication
public class JobApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(JobApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);
    }
}
