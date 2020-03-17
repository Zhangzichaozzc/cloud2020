package com.customer.springcloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConsumerController
 *
 * @author Zichao Zhang
 * @date 2020/3/17
 */
@RestController
@EnableBinding(Sink.class)
public class ConsumerController {

    @GetMapping("/recevice")
    // Sink.INPUT 为SubscribableChannel 的一个 beanName, 已经在容器中注册了
    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        System.out.println("接收到 MQ 的信息: " + message.getPayload());
    }

}
