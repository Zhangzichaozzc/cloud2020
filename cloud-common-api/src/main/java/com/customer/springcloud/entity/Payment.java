package com.customer.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Payment
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Payment {

    private Long id;
    private String serial;

}
