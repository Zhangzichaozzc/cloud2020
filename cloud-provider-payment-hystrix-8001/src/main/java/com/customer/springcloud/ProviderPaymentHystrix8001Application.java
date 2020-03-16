package com.customer.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

/**
 * com.customer.springcloud.ProviderPaymentHystrix8001Application
 *
 * @author Zichao Zhang
 * @date 2020/3/16
 */
@SpringBootApplication
@EnableCircuitBreaker
public class ProviderPaymentHystrix8001Application {
    public static void main(String[] args) {
        SpringApplication.run(ProviderPaymentHystrix8001Application.class, args);
    }

    /**
     * Spring Cloud 升级后，如果需要 使用 Hystrix Dashboard 进行监控，需要在被监控的应用中添加以下 Servlet
     */
    @Bean
    public ServletRegistrationBean<HystrixMetricsStreamServlet> getServelt() {
        HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> servlet =
                new ServletRegistrationBean<>(hystrixMetricsStreamServlet);
        servlet.setLoadOnStartup(1);
        servlet.addUrlMappings("/hystrix.stream");
        servlet.setName("HystrixMetricsStreamServlet");
        return servlet;
    }
}
