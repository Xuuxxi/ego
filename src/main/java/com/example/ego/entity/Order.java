package com.example.ego.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/25
 */
@TableName("order")
@Data
public class Order {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd" ,timezone = "GMT+8")
    private Date date;  //订单创建时间，格式为 yyyy-MM-dd

    private Buyer buyer;    //买家信息
    private Seller seller;  //卖家信息
    private Good good;  //商品信息
}
