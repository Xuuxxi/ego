package com.example.ego.server;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ego.entity.User;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/26
 */
public interface UserServer {
    User login(User user);

    User getUserInfo(String username);

    User getUserInfo(Integer userId);

    Page<User> roleGetUserInfo(Integer pageNum, Integer pageSize);
}
