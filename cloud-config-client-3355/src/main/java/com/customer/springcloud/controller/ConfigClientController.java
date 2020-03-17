package com.customer.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigClientController
 *
 * @author Zichao Zhang
 * @date 2020/3/17
 */
@RestController
// 刷新 监控节点信息
@RefreshScope
public class ConfigClientController {

    @Value("${info.name}")
    private String infoName;

    @GetMapping("/infoName")
    public String getInfoName() {
        return infoName;
    }

}
