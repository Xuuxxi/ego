package com.example.ego.controller;

import com.example.ego.common.util.Result;
import com.example.ego.entity.Order;
import com.example.ego.mapper.OrderMapper;
import com.example.ego.server.OrderServerImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/25
 */

@RestController
@RequestMapping("/transaction")
public class TransactionInfoController {
    @Resource
    OrderServerImpl orderServer;

    @GetMapping//通过订单id搜索订单
    public Result<?> getOrder(Integer orderId){
        Order order = orderServer.getOrder(orderId);

        if(order == null) return Result.error("-1","不存在符合条件的订单");

        return Result.success(order);
    }
}
