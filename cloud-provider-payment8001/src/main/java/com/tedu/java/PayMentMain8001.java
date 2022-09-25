package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author： zyy
 * @date： 2022/9/18 15:33
 * @description： TODO
 * @version: 1.0
 * @描述：程序入口
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PayMentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8001.class,args);
    }
}
