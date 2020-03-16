package com.customer.springcloud.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import cn.hutool.core.util.IdUtil;

/**
 * 服务熔断状态： 熔断打开、熔断关闭、熔断半开
 * 熔断打开: 请求不再调用当前服务，内部设置时钟一般为 MTTR(平均故障处理时间),当打开时长达到所设时钟则进入版熔断状态
 * 熔断关闭: 熔断关闭不会对服务进行熔断
 * 熔断半开: 部分请求根据规则调用当前服务，如果请求成功且符合规则则认为当前服务恢复正常，关闭熔断
 */
@Service
public class PayService {

    @Value("${server.port}")
    private Integer port;

    public String hystrixOk() {
        System.err.println("OK " + port);
        return "OK " + port;
    }

    /**
     * 在此方法上服务降级处理，设置 方法调用的最大可容忍超时时间为 2500毫秒，超过了则会降级助理
     * 服务降级处理，使用  @HystrixCommand 注解完成, 使用了 @HystrixCommand 后需要在主启动类上标注 @EnableCircuitBreak
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "timeoutHanlder", commandProperties = {
            // 设置 可以容忍的超时时间，超过这个时间则会服务降级处理
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2500")
    })
    public String hystrixTimeout() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.println("延时 3 秒后响应: " + port);
        return "延时 3 秒后响应: " + port;
    }

    public String timeoutHanlder() {
        return "服务降级处理了";
    }

    /**
     * 熔断器的三个参数：快照时间窗口、请求总数阈值、错误百分比阈值
     * 1、快照时间窗口: 熔断器确定是否打开需要统一一些请求和错误数据，而统计的时间范围就是快照时间窗口，默认是最近10秒
     * 2、请求总数阈值: 在快照时间窗口内，必须满足请求总数阈值才能有资格熔断，默认是20，以为着在10秒内，如果该 Hystrix 命令的调用次数不足20次
     * 即是所有的请求都超时或其他原因调用失败，熔断器都不会打开
     * 3、错误百分比阈值: 当请求总数在快照时间窗口内超过了阈值，如发生了30次调用，如果在这30次调用中，有15次发生了异常，也就是50%的错误百分比，
     * 如果默认的错误百分比阈值是 50%， 则这时会打开熔断器
     */
    @HystrixCommand(fallbackMethod = "circuitFallback", commandProperties = {
            // 开启服务熔断
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 服务熔断开启后，评测什么时候开启服务熔断，指定多少次内的请求作为评测标准
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 指定 多少时间作为评测标准, 即时间窗口期
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 在指定时间，指定次数的情况下，如果 服务降级的百分比 超过 60%, 则服务熔断, 过一段时间，如果服务可以正常调用，则恢复正常
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String circuitBreaker(Integer id) {
        if (id > 0) {
            return "服务没有发生熔断，正常返回" + IdUtil.simpleUUID();
        } else {
            throw new RuntimeException();
        }
    }

    public String circuitFallback(Integer id) {
        return "服务降级处理了...";
    }

}
