package com.tedu.java.service;


import com.tedu.java.pojo.CommonResult;
import com.tedu.java.pojo.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回---PaymentFallbackService",new Payment(id,"errorService"));
    }
}
