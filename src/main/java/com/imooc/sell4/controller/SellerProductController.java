package com.imooc.sell4.controller;

import com.imooc.sell4.dataobject.ProductCategory;
import com.imooc.sell4.dataobject.ProductInfo;
import com.imooc.sell4.exception.SellException;
import com.imooc.sell4.form.ProductForm;
import com.imooc.sell4.service.CategoryService;
import com.imooc.sell4.service.ProductService;
import com.imooc.sell4.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/seller/product")
public class SellerProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "2") Integer size,
                             Map<String, Object> map){
        PageRequest request = new PageRequest(page-1, size);
        Page<ProductInfo> productInfoPage = productService.findAll(request);
        map.put("productInfoPage", productInfoPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("product/list", map);
    }

    @GetMapping("on_sale")
    public ModelAndView onSale(@RequestParam(value = "productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.onSale(productId);
        }catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("off_sale")
    public ModelAndView offSale(@RequestParam(value = "productId") String productId,
                               Map<String, Object> map) {
        try {
            productService.offSale(productId);
        }catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                      Map<String, Object> map) {
        if(!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productService.findOne(productId);
            map.put("productInfo", productInfo);
        }

        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);

        return new ModelAndView("product/index", map);
    }

    @PostMapping("/save")
//    @CachePut(cacheNames = "product", key = "123")
    @CacheEvict(cacheNames = "product", key = "123")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map) {

        if(bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);
        }

        ProductInfo productInfo = new ProductInfo();
        try {
            if(!StringUtils.isEmpty(form.getProductId())) {
                productInfo = productService.findOne(form.getProductId());
            }else {
                form.setProductId(KeyUtil.genUniqueKey());
                productInfo.setCreateTime(new Date());
                productInfo.setUpdateTime(new Date());
            }

            BeanUtils.copyProperties(form, productInfo);

            productService.save(productInfo);
        }catch (SellException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/product/index");
            return new ModelAndView("common/error", map);

        }
        map.put("url", "/sell/seller/product/list");
        return new ModelAndView("common/success", map);
    }
}
