package com.example.test01.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test01.common.Result;
import com.example.test01.entity.User;
import com.example.test01.mapper.UserMapper;
import com.example.test01.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: 天之璎珞
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public Result<?> selectUser(User user) {
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword()));
        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }else {
            return Result.success(res);
        }
    }

    @Override
    public Result<?> selectOne(User user) {
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()));
        if(res != null){
            return Result.error("-1","用户名重复");
        }
        userMapper.insert(user);
        return Result.success();
    }

    @Override
    public Result<?> selectSave(User user) {
        userMapper.insert(user);
        return Result.success();
    }

    @Override
    public Result<?> selectUpdate(User user) {
        userMapper.updateById(user);
        return Result.success();
    }

    @Override
    public Result<?> selectDelete(Long id) {
        userMapper.deleteById(id);
        return Result.success();
    }

    @Override
    public Result<?> selectPage(Page page,String search) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            wrapper.like(User::getNickName,search);
        }
        Page<User> userPage = userMapper.selectPage(page,wrapper);
        return Result.success(userPage);
    }
}
