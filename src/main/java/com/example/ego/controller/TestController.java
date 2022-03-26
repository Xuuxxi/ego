package com.example.ego.controller;

import com.example.ego.common.util.Result;
import com.example.ego.entity.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/26
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public Result<?> forGet(){
        return Result.success(new User(1));
    }

    @PostMapping
    public Result<?> forPost(@RequestBody Integer num){
        return Result.success("Success Post , num = " + num);
    }
}
