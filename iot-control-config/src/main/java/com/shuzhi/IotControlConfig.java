package com.shuzhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
* @Program: IotControlConfig
* @Description:
* @Author: YuJQ
* @Create: 2019/7/22 16:59
**/
@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进eureka服务中
@EnableDiscoveryClient //服务发现
public class IotControlConfig {
    public static void main(String[] args)
    {
        SpringApplication.run(IotControlConfig.class, args);
    }

}
