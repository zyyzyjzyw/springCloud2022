package com.tedu.myRibbRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author： zyy
 * @date： 2022/9/26 21:14
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Configuration
public class MySelfRule {
    @Bean
    public IRule myRule(){
        return new RandomRule();//自定义为随机
    }
}
