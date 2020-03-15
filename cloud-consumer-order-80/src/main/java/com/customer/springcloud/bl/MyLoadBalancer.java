package com.customer.springcloud.bl;

import java.util.List;

import org.springframework.cloud.client.ServiceInstance;

/**
 * MyLoadBalancer
 *
 * @author Zichao Zhang
 * @date 2020/3/15
 */
public interface MyLoadBalancer {
    ServiceInstance getService(List<ServiceInstance> serviceInstances);
}
