package com.example.ego.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/25
 */
@TableName("transaction")
@Data   //forUser
public class TransactionInfo {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private boolean isSeller;   //是否为卖家
    private boolean type;   //卖则为 true

    private Good good;  //交易的商品
}
