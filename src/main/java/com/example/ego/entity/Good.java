package com.example.ego.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/25
 */

@TableName("good")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    private String name;
    private String price;
    private String url; //商品图片
    private List<String> infoUrl;   //具体内容图
    private String category;    //商品种类
    private String info;    //商品介绍

    private Seller seller;
    private String sellerName = seller.getName();   //卖家信息
    private List<Integer> buyerId;    //买家信息    //非必要*****

    private List<Integer> subscriberId;  //收藏该商品的id
    private Boolean isStared;   //是否被喜欢      //用户即role=2的时候查看
    private Boolean isVerified; //审核是否通过    //管理员即role=1的时候查看
}
