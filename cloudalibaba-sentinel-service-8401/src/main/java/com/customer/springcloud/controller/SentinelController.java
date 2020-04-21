package com.customer.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * SentinelController
 *
 * @author Zichao Zhang
 * @date 2020/3/19
 */
@RestController
@Slf4j
public class SentinelController {

    @GetMapping("/testA")
    public String testA() {
        try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "----------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info("..................testB");
        return "----------testB";
    }
}
