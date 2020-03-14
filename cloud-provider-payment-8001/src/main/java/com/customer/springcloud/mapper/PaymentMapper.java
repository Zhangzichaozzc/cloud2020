package com.customer.springcloud.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.customer.springcloud.entity.Payment;

/**
 * PaymentMapper
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
public interface PaymentMapper {
    @Options(useGeneratedKeys = true)
    @Insert("insert into payment(serial) values (#{serial})")
    int save(Payment payment);

    @Select("select id, serial from payment where id = #{id}")
    Payment getById(Long id);
}
