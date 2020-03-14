package com.customer.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CommonResult
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@Data
@AllArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T data;

    public CommonResult() {
        this.code = 200;
        this.message = "Success";
    }

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }

}
