package com.imooc.sell4.dto;

import lombok.Data;

@Data
public class CartDTO {

    private String productId;

    private Integer productQunantity;

    public CartDTO(String productId, Integer productQunantity) {
        this.productId = productId;
        this.productQunantity = productQunantity;
    }
}
