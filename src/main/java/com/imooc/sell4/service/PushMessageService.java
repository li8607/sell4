package com.imooc.sell4.service;

import com.imooc.sell4.dto.OrderDTO;

public interface PushMessageService {

    public void orderStatus(OrderDTO orderDTO);

}
