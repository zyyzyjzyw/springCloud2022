package com.tedu.java.controller;

import com.tedu.java.service.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： zyy
 * @date： 2022/9/30 9:15
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentServiceImpl paymentService;
    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_ok(id);
        log.info("***************result:"+result);
        return result;
    }
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_timeout(id);
        log.info("***************result:"+result);
        return result;
    }
    //***************服务熔断
    @GetMapping("info/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String res = paymentService.paymentCircuitBreaker(id);
        return res;
    }
}
