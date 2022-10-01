package com.tedu.java.service;

import org.springframework.stereotype.Component;

/**
 * @author： zyy
 * @date： 2022/9/30 23:48
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-------------PaymentFallbackService fall back-paymentInfo_ok.....";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-------------PaymentFallbackService fall back-paymentInfo_timeout.....";
    }
}
