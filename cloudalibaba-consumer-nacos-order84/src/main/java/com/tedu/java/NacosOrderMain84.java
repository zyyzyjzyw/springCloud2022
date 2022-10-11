package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author： zyy
 * @date： 2022/10/10 21:34
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class NacosOrderMain84 {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain84.class,args);
    }
}
