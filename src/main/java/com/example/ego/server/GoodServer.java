package com.example.ego.server;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ego.entity.Good;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/26
 */
public interface GoodServer {
    Page<Good> getGoodsList(@RequestParam(defaultValue = "1") Integer pageNum,    //页数
                            @RequestParam(defaultValue = "10") Integer pageSize,  //每页数据大小
                            @RequestParam(defaultValue = "") String category);

    Good getGood(String sellerName,Integer userId);

    Good getGood(Integer goodId,Integer userId);
}
