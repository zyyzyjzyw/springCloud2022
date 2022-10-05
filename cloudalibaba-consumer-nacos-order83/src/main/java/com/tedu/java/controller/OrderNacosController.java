package com.tedu.java.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author： zyy
 * @date： 2022/10/5 12:41
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RestController
@Slf4j
public class OrderNacosController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${server-url.nacos-user-service}")
    private String url;

    @GetMapping("/order/getPayment/{id}")
    public String getPaymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject(url+"/payment/getPayment/"+id,String.class);
    }
}
