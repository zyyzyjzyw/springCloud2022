package com.tedu.java.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tedu.java.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： zyy
 * @date： 2022/9/30 10:17
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_global_fallbackMethod")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_ok(id);
        return result;
    }
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")})
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_timeout(id);
        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙，请10秒后再试或者自己运型出错请检查自己!!!";
    }

    //下面是全局fallback
    public String payment_global_fallbackMethod(){
        return "Global异常处理信息，请稍后再试!!!!";
    }
}
