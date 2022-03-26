package com.example.ego.server;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ego.entity.User;
import com.example.ego.mapper.UserMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/26
 */
public class UserServerImpl implements UserServer{

    @Resource
    UserMapper userMapper;

    @Transactional
    @Override
    public User login(User user) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword()));
    }

    @Transactional
    @Override
    public User getUserInfo(String username) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));
    }

    @Transactional
    @Override
    public User getUserInfo(Integer userId) {
        return userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId,userId));
    }

    @Transactional
    @Override
    public Page<User> roleGetUserInfo(Integer pageNum, Integer pageSize) {
        return userMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<User>lambdaQuery().eq(User::getRole, 2));
    }
}
