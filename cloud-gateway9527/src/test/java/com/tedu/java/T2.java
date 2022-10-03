package com.tedu.java;

import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author： zyy
 * @date： 2022/10/2 11:43
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
public class T2 {
    @Test
    public void test01(){
        ZonedDateTime zbj = ZonedDateTime.now();
        System.out.println(zbj);
        //2022-10-02T11:46:37.184+08:00[Asia/Shanghai]
    }
}
