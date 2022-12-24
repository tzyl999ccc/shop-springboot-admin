package com.example.test01.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test01.common.Result;
import com.example.test01.entity.ProductInfo;
import com.example.test01.entity.User;

/**
 * @description:
 * @author: 天之璎珞
 */
public interface ProductInfoService {
    Result<?> insertProductInfo(ProductInfo productInfo);

    Result<?> updateProductInfo(ProductInfo productInfo);

    Result<?> deleteProductInfo(Long id);

    Result<?> findAllProductInfo(Page page, String search);

    Result<?> findAll();
}
