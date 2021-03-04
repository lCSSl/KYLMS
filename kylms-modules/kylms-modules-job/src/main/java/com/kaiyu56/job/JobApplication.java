package com.kaiyu56.job;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import com.kaiyu56.common.security.annotation.EnableCustomConfig;
import com.kaiyu56.common.security.annotation.EnableRyFeignClients;
import com.kaiyu56.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 *
 * @author css
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringCloudApplication
public class JobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(JobApplication.class, args);
    }
}
