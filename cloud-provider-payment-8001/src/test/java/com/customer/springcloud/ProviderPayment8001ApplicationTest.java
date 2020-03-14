package com.customer.springcloud;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.customer.springcloud.entity.Payment;
import com.customer.springcloud.mapper.PaymentMapper;

/**
 * ProviderPayment8001ApplicationTest
 *
 * @author Zichao Zhang
 * @date 2020/3/14
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProviderPayment8001ApplicationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PaymentMapper paymentMapper;

    @Test
    public void testDataSource() throws SQLException {
        System.err.println("dataSource = " + dataSource.getClass());
        System.err.println("dataSource.getConnection() = " + dataSource.getConnection());
    }

    @Test
    public void testMapper() {
        Payment payment = new Payment().setSerial(UUID.randomUUID().toString());
        paymentMapper.save(payment);
        System.err.println(payment);
    }

}