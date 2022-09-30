package com.tedu.java.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author： zyy
 * @date： 2022/9/29 12:36
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
