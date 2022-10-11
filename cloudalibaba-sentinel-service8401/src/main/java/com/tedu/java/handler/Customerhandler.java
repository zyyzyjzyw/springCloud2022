package com.tedu.java.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tedu.java.pojo.CommonResult;
import com.tedu.java.pojo.Payment;

/**
 * @author： zyy
 * @date： 2022/10/10 21:08
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
public class Customerhandler {
    public static CommonResult handlerException1(BlockException exception){
        return new CommonResult(444,"按客户自定义,global handlerException1",new Payment(2020L,"serial002"));
    }
    public CommonResult handlerException2(BlockException exception) {
        return new CommonResult(444,"按客户自定义，global handlerException2",new Payment(2020L,"serial003"));
    }
}
