package com.example.ego.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/25
 */
@TableName("seller")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seller {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
}
