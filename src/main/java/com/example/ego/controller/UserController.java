package com.example.ego.controller;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/24
 */

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.ego.common.Result;
import com.example.ego.entity.User;
import com.example.ego.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    @PostMapping//登录
    public Result<?> login(@RequestBody User user){
        User res = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, user.getUsername()).eq(User::getPassword, user.getPassword()));

        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }

        return Result.success(res.getId());
    }

    @GetMapping
    public Result<?> getUserInfo(String username){
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, username));

        if(user == null){
            return Result.error("-1","用户名或密码错误");
        }

        return Result.success(user);
    }

    @GetMapping
    public Result<?> getUserInfo(Integer userId){
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId,userId));

        if(user == null){
            return Result.error("-1","用户名或密码错误");
        }

        return Result.success(user);
    }
}

