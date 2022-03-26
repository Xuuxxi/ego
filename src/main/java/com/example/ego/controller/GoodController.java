package com.example.ego.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ego.common.util.Result;
import com.example.ego.entity.Good;
import com.example.ego.mapper.GoodMapper;
import com.example.ego.server.GoodServerImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/25
 */

@RestController
@RequestMapping("/good")
public class GoodController {
    @Resource
    GoodServerImpl goodServer;

    @GetMapping//按商品分类名获取,分页展示
    public Result<?> getGoodsList(@RequestParam(defaultValue = "1") Integer pageNum,    //页数
                                  @RequestParam(defaultValue = "10") Integer pageSize,  //每页数据大小
                                  @RequestParam(defaultValue = "") String category){
        Page<Good> goods = goodServer.getGoodsList(pageNum,pageSize,category);

        if(goods == null) return Result.error("-1","不存在符合要求的商品");

        return Result.success(goods);
    }


    @GetMapping//根据商品名字和用户id获取
    public Result<?> getGood(String sellerName,Integer userId){
        Good good = goodServer.getGood(sellerName,userId);
        List<Integer> buyerId = good.getBuyerId();

        if(buyerId.contains(userId)) {
            List<Integer> subscriberId = good.getSubscriberId();
            good.setIsStared(subscriberId.contains(userId));

            return Result.success(good);
        }

        return Result.error("-1","不存在符合要求的商品");
    }

    @GetMapping//根据商品id和用户id获取
    public Result<?> getGood(Integer goodId,Integer userId){
        Good good = goodServer.getGood(goodId,userId);
        List<Integer> buyerId = good.getBuyerId();

        if(buyerId.contains(userId)) {
            List<Integer> subscriberId = good.getSubscriberId();
            good.setIsStared(subscriberId.contains(userId));

            return Result.success(good);
        }

        return Result.error("-1","不存在符合要求的商品");
    }
}
