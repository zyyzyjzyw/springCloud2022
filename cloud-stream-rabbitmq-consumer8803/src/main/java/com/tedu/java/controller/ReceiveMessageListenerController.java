package com.tedu.java.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： zyy
 * @date： 2022/10/4 15:27
 * @description： TODO
 * @version: 1.0
 * @描述：
 **/
@RestController
@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {
    @Value("${server.port}")
    private String serverPort;
    @StreamListener(Sink.INPUT)
    public void input(Message<String>message){
        System.out.println("消费者2号......接收到的消息: "+message.getPayload()+"\t port: "+serverPort);
    }
}
