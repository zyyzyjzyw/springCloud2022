package com.tedu.java.controller;

import com.tedu.java.pojo.CommonResult;
import com.tedu.java.pojo.Payment;
import com.tedu.java.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author： zyy
 * @date： 2022/9/18 16:37
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Value("${server.port}")
    private String serverPort;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入结果:" + result);
        if (result > 0) {
            return new CommonResult(200, "插入结果成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入结果失败!!serverPort:"+serverPort);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment paymentResult = paymentService.getPaymentById(id);
        log.info("*******插入结果为:" + paymentResult);
        if (paymentResult != null) {
            return new CommonResult(200, "查询结果成功,serverPort:"+serverPort, paymentResult);
        } else {
            return new CommonResult(444, "没有对应记录!!查询id为:"+id+",serverPort:"+serverPort);
        }
    }
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element:services){
            log.info("*******element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getUri()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipKin(){
        return "Hi,I`m paymentzipKip server fall back,哈哈!!!!";
    }
}
