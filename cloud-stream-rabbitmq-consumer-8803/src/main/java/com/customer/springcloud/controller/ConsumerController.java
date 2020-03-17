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
 * @date 2020/3/18
 */
@RestController
@EnableBinding(Sink.class)
public class ConsumerController {

    @GetMapping("/receive")
    @StreamListener(Sink.INPUT)
    public void receive(Message<String> message) {
        System.out.println("接收到消息中间件的消息: " + message.getPayload());
    }

}
