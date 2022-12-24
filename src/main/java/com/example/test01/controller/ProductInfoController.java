package com.example.test01.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.test01.common.Result;
import com.example.test01.entity.ProductInfo;
import com.example.test01.mapper.ProductInfoMapper;

import com.example.test01.service.ProductInfoService;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: 天之璎珞
 */
@RestController
@RequestMapping("/productInfo")
public class ProductInfoController {

    @Resource
    ProductInfoMapper productInfoMapper;

    @Resource
    ProductInfoService productInfoService;


    @PostMapping
    public Result<?> save(@RequestBody ProductInfo productInfo){
        Result<?> res = productInfoService.insertProductInfo(productInfo);
        return res;
    }

    @PutMapping
    public Result<?> update(@RequestBody ProductInfo productInfo){
        Result<?> res = productInfoService.updateProductInfo(productInfo);
        return res;
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        Result<?> res = productInfoService.deleteProductInfo(id);
        return res;
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        Page<Object> page = new Page<>(pageNum, pageSize);
        Result<?> res = productInfoService.findAllProductInfo(page,search);
        return res;

    }

    @GetMapping("/findAll")
    public Result<?> findAll() {
        Result<?> res = productInfoService.findAll();
        return res;
    }



}
