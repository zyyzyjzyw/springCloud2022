package com.tedu.java.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author： zyy
 * @date： 2022/10/9 20:01
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RestController
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA(){
        try {
            TimeUnit.MICROSECONDS.sleep(800);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "-----------testA";
    }
    @GetMapping("/testB")
    public String testB(){
        return "-----------testB";
    }
    @RequestMapping("testC")
    public String testC(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "testC 测试RT-------";
    }
    @RequestMapping("testD")
    public String testD(){
        System.out.println("testD 异常比例测试");
        int age = 10/0;
        return "testD-------";
    }

    @RequestMapping("testE")
    public String testE(){
        System.out.println("testD 异常s数--测试");
        int age = 10/0;
        return "testD-------";
    }

    @RequestMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKet")
    public String testHotKey(
            @RequestParam(value = "p1",required = false) String p1,
            @RequestParam(value = "p2",required = false) String p2
    ){
        System.out.println("testHotKey 热点Key--测试");
        int age = 10/0;
        return "testHotKey-------";
    }

    public String deal_testHotKet(String p1, String p2, BlockException e) {
        return "----deal_testHotKet,------";
    }

}
