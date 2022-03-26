package com.example.ego.entity;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/24
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private Integer role;   //管理员 1，普通用户 2
    private String username;    //登录名称
    private String password;    //登录密码

    private String url;     //头像url
    private String address; //用户地址

    private List<Good> favoriteProducts;    //喜欢的商品

    private List<TransactionInfo> infos; //交易记录
}
