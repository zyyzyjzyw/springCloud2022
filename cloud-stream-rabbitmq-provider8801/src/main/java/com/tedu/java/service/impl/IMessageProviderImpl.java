package com.tedu.java.service.impl;

import com.tedu.java.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.UUID;

/**
 * @author： zyy
 * @date： 2022/10/4 13:20
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@EnableBinding(Source.class) //定义消息的推送管道
public class IMessageProviderImpl implements IMessageProvider {
    @Autowired
    private MessageChannel output; //消息发送通道
    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial为: "+serial);
        return null;
    }
}
