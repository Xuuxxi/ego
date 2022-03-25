package com.example.ego.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/25
 */
@TableName("buyer")
@Data
public class Buyer {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String name;
    private String address;
    private String phone;
}
