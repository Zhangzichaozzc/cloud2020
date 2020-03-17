package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.springcloud.service.IMessageProvider;

/**
 * ProviderControlle
 *
 * @author Zichao Zhang
 * @date 2020/3/17
 */
@RestController
public class ProviderControlle {

    @Autowired
    private IMessageProvider messageProvider;

    @GetMapping("/send")
    public String send() {
        messageProvider.send();
        return "SUCCESS";
    }

}
