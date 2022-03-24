package com.example.ego.controller;

import com.example.ego.common.Result;
import com.example.ego.entity.User;
import com.example.ego.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    public Result<?> save(@RequestBody User user){
        userMapper.insert(user);
        return Result.success();
    }
}
