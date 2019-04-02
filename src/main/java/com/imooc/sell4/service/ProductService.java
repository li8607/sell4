package com.imooc.sell4.service;

import com.imooc.sell4.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    ProductInfo findOne(String productId);

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /**
     * 查询所有在架商品列表
     */
    List<ProductInfo> findUpAll();

    //加库存

    //减库存

}
