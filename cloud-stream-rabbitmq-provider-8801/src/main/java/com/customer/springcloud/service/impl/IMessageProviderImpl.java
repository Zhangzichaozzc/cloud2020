package com.customer.springcloud.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import com.customer.springcloud.service.IMessageProvider;

/**
 * IMessageProviderImpl
 *
 * @author Zichao Zhang
 * @date 2020/3/17
 */
// 定义 推送信息的通道
@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道, 这里必须指定 MessageChannel 的beanName， 因为在容器中已经注册了 三个 MessageChannel Bean
     */
    @Qualifier("output")
    @Autowired
    private MessageChannel out;

    @Override
    public void send() {
        String serial = UUID.randomUUID().toString();
        // 构建 Message 对象并发送消息
        out.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********" + serial);
    }
}
