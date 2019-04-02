package com.imooc.sell4.controller;

import com.imooc.sell4.converter.OrderForm2OrderDTOConverter;
import com.imooc.sell4.dto.OrderDTO;
import com.imooc.sell4.enums.ResultEnum;
import com.imooc.sell4.exception.SellException;
import com.imooc.sell4.form.OrderForm;
import com.imooc.sell4.service.impl.OrderServiceImpl;
import com.imooc.sell4.utils.ResultVOUtil;
import com.imooc.sell4.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderServiceImpl orderService;
//    name:张三
//    phone:18868822111
//    address:慕课网总部
//    openid:ew3euwhd7sjw9diwkq
//    items:[{productId:"123213",productQuantity:2}]
    //创建订单
    @PostMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm,
                                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】 参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode()
                    , bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);

        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        OrderDTO result = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", result.getOrderId());

        return ResultVOUtil.success(map);
    }


    //订单列表

    //订单详情

    //取消订单

}
