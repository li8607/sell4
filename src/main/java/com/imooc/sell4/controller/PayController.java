package com.imooc.sell4.controller;

import com.imooc.sell4.dto.OrderDTO;
import com.imooc.sell4.enums.ResultEnum;
import com.imooc.sell4.exception.SellException;
import com.imooc.sell4.service.OrderService;
import com.imooc.sell4.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam(value = "orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
//        payService.create(orderDTO);
        return new ModelAndView("pay/create");
    }

}
