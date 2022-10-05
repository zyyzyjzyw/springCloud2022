package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author： zyy
 * @date： 2022/10/5 13:13
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigNacosMain3377 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigNacosMain3377.class,args);
    }
}