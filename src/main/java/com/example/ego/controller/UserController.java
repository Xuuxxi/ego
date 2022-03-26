package com.example.ego.controller;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/24
 */

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ego.common.util.Result;
import com.example.ego.entity.User;
import com.example.ego.mapper.UserMapper;
import com.example.ego.server.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserServerImpl userServer;

    @PostMapping//登录
    public Result<?> login(@RequestBody User user){
        User res = userServer.login(user);

        if(res == null){
            return Result.error("-1","用户名或密码错误");
        }

        return Result.success(res.getId());
    }

    @GetMapping//获取用户信息
    public Result<?> getUserInfo(String username){
        User user = userServer.getUserInfo(username);

        if(user == null){
            return Result.error("-1","用户名或密码错误");
        }

        return Result.success(user);
    }

    @GetMapping
    public Result<?> getUserInfo(Integer userId){
        User user = userServer.getUserInfo(userId);

        if(user == null){
            return Result.error("-1","用户名或密码错误");
        }

        return Result.success(user);
    }

    @GetMapping//管理员获取用户信息
    public Result<?> roleGetUserInfo(@RequestParam(defaultValue = "1") Integer pageNum,    //页数
                                     @RequestParam(defaultValue = "10") Integer pageSize)  //每页数据大小
    {
        Page<User> user = userServer.roleGetUserInfo(pageNum,pageSize);

        if(user == null) return Result.error("-1","暂无非管理员用户数据");

        return Result.success(user);
    }
}

