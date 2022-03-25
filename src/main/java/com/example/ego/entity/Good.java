package com.example.ego.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.List;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/25
 */

@TableName("good")
@Data
public class Good {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String price;
    private String url; //商品图片
    private String category;    //商品种类

    private Seller seller;
    private String sellerName = seller.getName();   //卖家信息
    private List<Integer> buyerId;    //买家信息

    private List<Integer> subscriberId;  //收藏该商品的id
    private Boolean isStared;   //是否被喜欢，selectOne 使用
}
