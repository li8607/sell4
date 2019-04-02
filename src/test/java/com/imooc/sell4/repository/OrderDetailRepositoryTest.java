package com.imooc.sell4.repository;

import com.imooc.sell4.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1232155");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductId("21321312666");
        orderDetail.setProductName("皮蛋粥1");
        orderDetail.setProductPrice(new BigDecimal(5.2));
        orderDetail.setProductQuantity(200);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrOrderIdTest() {
        List<OrderDetail> orderDetailList = repository.findByOrOrderId("123456");
        Assert.assertNotEquals(0, orderDetailList.size());
    }


}