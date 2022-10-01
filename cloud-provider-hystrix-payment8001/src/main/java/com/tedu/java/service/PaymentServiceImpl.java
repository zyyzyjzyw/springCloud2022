package com.tedu.java.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author： zyy
 * @date： 2022/9/30 8:59
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@Service
public class PaymentServiceImpl {
    //正常访问，ok
    public String paymentInfo_ok(Integer id){
        return "线程池: "+Thread.currentThread().getName()
                +"  paymentInfo_ok,id: "+id+"\t"+"哈哈~~~";
    }
    @HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties =
            {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentInfo_timeout(Integer id){
        //暂停几秒钟
        int timeNumber = 5;
        try {

            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池: "+Thread.currentThread().getName()
                +"  paymentInfo_timeout,id: "+id+"\t"+"哈哈~~~,耗时"+timeNumber+"秒钟";
    }
    public String paymentInfo_timeoutHandler(Integer id){
        return "线程池: "+Thread.currentThread().getName()
                +"  paymentInfo_timeoutHandler,id: "+id+"\t"+"哈哈~~~";
    }
    //================服务熔断
    @HystrixCommand(
            fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸

    }
    )
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id<0) {
            throw new RuntimeException("******id不能为负数");
        }
        String simpleUUID = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t" + "成功调用，流水号是：" + simpleUUID;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id不能为负数，请稍后再试............"+id;
    }
}
