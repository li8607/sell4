package com.imooc.sell4.service.impl;

import com.imooc.sell4.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl service;

    @Test
    public void findOne() {
        ProductCategory category = service.findOne(1);
        Assert.assertEquals(new Integer(1), category.getCategoryId());
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategoryList = service.findAll();
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = service.findByCategoryTypeIn(Arrays.asList(91,5,11,70));
        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() {
        ProductCategory category = new ProductCategory("男生专享", 1);
        ProductCategory result = service.save(category);
        Assert.assertNotNull(result);

    }
}