package com.example.test01.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test01.common.Result;
import com.example.test01.entity.ProductInfo;
import com.example.test01.mapper.ProductInfoMapper;
import com.example.test01.service.ProductInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: 天之璎珞
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Resource
    ProductInfoMapper productInfoMapper;

    @Override
    public Result<?> insertProductInfo(ProductInfo productInfo) {
        productInfoMapper.insert(productInfo);
        return Result.success();
    }

    @Override
    public Result<?> updateProductInfo(ProductInfo productInfo) {
        productInfoMapper.updateById(productInfo);
        return Result.success();
    }

    @Override
    public Result<?> deleteProductInfo(Long id) {
        productInfoMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result<?> findAllProductInfo(Page page, String search) {
        LambdaQueryWrapper<ProductInfo> wrapper = Wrappers.<ProductInfo>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(ProductInfo::getName,search);
        }
        Page<ProductInfo> ProductInfoPage = productInfoMapper.selectPage(page,wrapper);
        System.out.println(ProductInfoPage);
        return Result.success(ProductInfoPage);
    }

    @Override
    public Result<?> findAll() {
        List<ProductInfo> productInfos = productInfoMapper.selectList(null);
        return Result.success(productInfos);
    }


}
