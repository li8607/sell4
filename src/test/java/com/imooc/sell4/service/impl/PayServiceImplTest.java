package com.imooc.sell4.service.impl;

import com.imooc.sell4.dto.OrderDTO;
import com.imooc.sell4.service.OrderService;
import com.imooc.sell4.service.PayService;
import com.lly835.bestpay.service.BestPayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService service;

    @Test
    public void createTest() {
        OrderDTO orderDTO = service.findOne("1554431939428320184");
        payService.create(orderDTO);
    }
}