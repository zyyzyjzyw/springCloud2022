package com.tedu.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author： zyy
 * @date： 2022/10/5 11:09
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderMain9002 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderMain9002.class,args);
    }
}
