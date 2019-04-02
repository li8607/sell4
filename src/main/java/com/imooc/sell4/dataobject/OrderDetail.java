package com.imooc.sell4.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /**
     * 订单id
     * */
    private String orderId;

    /**
     * 商品id
     * */
    private String productId;

    /**
     * 商品名称
     * */
    private String productName;

    /**
     * 商品单价
     * */
    private BigDecimal productPrice;

    /**
     * 商品数量
     * */
    private Integer productQuantity;

    /**
     * 商品小图
     * */
    private String productIcon;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "detailId='" + detailId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productIcon='" + productIcon + '\'' +
                '}';
    }
}
