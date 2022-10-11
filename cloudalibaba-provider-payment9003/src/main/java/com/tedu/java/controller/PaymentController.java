package com.tedu.java.controller;

import com.tedu.java.pojo.CommonResult;
import com.tedu.java.pojo.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author： zyy
 * @date： 2022/10/10 21:29
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RestController
public class PaymentController {

    @Value("${server.post}")
    private String serverPost;

    public static HashMap<Long, Payment> hashMap = new HashMap<>();
    static {
        hashMap.put(1L,new Payment(1L,"000000000000000001"));
        hashMap.put(2L,new Payment(2L,"000000000000000002"));
        hashMap.put(3L,new Payment(3L,"000000000000000003"));
    }

    @GetMapping(value = "/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable("id") Long id) {
        Payment payment = hashMap.get(id);
        CommonResult<Payment> result = new CommonResult<>(200,"from mysql,serverPort:"+serverPost);
        return result;
    }
}
