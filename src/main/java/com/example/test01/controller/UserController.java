package com.example.test01.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.example.test01.common.Result;
import com.example.test01.entity.User;
import com.example.test01.mapper.UserMapper;

import com.example.test01.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @description:
 * @author: 天之璎珞
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/login")
    public Result<?> login(@RequestBody User user){
        Result<?> res = userService.selectUser(user);
        return res;
    }


    @PostMapping("/register")
    public Result<?> register(@RequestBody User user){
        Result<?> res = userService.selectOne(user);
        if(user.getPassword() == null){
            user.setPassword("123456");
        }
        return res;
    }


    @PostMapping
    public Result<?> save(@RequestBody User user){
        if(user.getPassword() == null){
            user.setPassword("123456");
        }
        Result<?> res = userService.selectSave(user);
        return res;
    }

    @PutMapping
    public Result<?> update(@RequestBody User user){
        Result<?> res = userService.selectUpdate(user);
        return res;
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        Result<?> res = userService.selectDelete(id);
        return res;
    }

    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        Page<Object> page = new Page<>(pageNum, pageSize);
        Result<?> res = userService.selectPage(page,search);
        return res;
    }


}
