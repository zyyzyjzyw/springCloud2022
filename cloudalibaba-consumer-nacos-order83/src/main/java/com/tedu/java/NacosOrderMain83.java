package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author： zyy
 * @date： 2022/10/5 12:38
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosOrderMain83 {

    public static void main(String[] args) {
        SpringApplication.run(NacosOrderMain83.class,args);
    }
}
