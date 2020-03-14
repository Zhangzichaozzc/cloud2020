package com.customer.springcloud.exceptionnhandler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customer.springcloud.entity.CommonResult;

/**
 * HandlerExceptController
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@RestControllerAdvice
public class HandlerExceptController {

    @ExceptionHandler(Throwable.class)
    public CommonResult<?> handleExcept() {
        CommonResult<Object> result = new CommonResult<>();
        result.setCode(408);
        result.setMessage("Request Failed");
        return result;
    }

}
