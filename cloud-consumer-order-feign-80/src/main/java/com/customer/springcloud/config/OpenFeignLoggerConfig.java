package com.customer.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Logger;

/**
 * OpenFeignLoggerConfig
 *
 * @author Zichao Zhang
 * @date 2020/3/16
 */
@Configuration
public class OpenFeignLoggerConfig {

    @Bean
    public Logger.Level loggerLevel() {
        return Logger.Level.FULL;
    }

}
