package com.example.ego.entity;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/24
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("user")
@Data
public class User {
@TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
}
