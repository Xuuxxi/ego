package com.example.ego.server;

import com.example.ego.entity.Order;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/26
 */
public interface TransactionInfoServer {
    Order getOrder(Integer orderId);
}
