package com.customer.springcloud.bl;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

/**
 * 自定义 Round-Robin 算法，由于自定义的算法需要使用 ServiceInstance.getUri 来访问服务
 * 所以在使用自定义的 Round-Robin 算法的时候需要将 RestTemplate 上的 @LoadBalanced 注解注销掉
 */
@Component
public class MyBL implements MyLoadBalancer {

    private AtomicInteger accessNum = new AtomicInteger();

    private int incrementAndGet() {
        int current;
        int next;
        do {
            current = accessNum.get();
            next = current < 0 ? 0 : current + 1;
        } while (!accessNum.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance getService(List<ServiceInstance> serviceInstances) {
        int index = incrementAndGet() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
