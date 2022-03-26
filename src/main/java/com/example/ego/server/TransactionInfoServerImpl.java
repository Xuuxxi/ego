package com.example.ego.server;

import com.example.ego.entity.Order;
import com.example.ego.mapper.OrderMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/26
 */
public class TransactionInfoServerImpl implements TransactionInfoServer{
    @Resource
    OrderMapper orderMapper;

    @Transactional
    @Override
    public Order getOrder(Integer orderId) {
        return orderMapper.selectById(orderId);
    }
}
