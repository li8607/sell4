package com.imooc.sell4.dataobject.dao;

import com.imooc.sell4.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    public int insertByMap(Map<String, Object> map) {
        return productCategoryMapper.insertByMap(map);
    }
}
