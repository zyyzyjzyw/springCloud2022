package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class PayMentMain8002 {
    public static void main(String[] args) {
        SpringApplication.run(PayMentMain8002.class,args);
    }
}
