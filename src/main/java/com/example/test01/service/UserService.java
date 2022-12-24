package com.example.test01.service;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.test01.common.Result;
import com.example.test01.entity.User;

/**
 * @description:
 * @author: 天之璎珞
 */

public interface UserService {
    Result<?> selectUser(User user);

    Result<?> selectOne(User user);

    Result<?> selectSave(User user);

    Result<?> selectUpdate(User user);

    Result<?> selectDelete(Long id);

    Result<?> selectPage(Page page, String search);
}
