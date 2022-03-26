package com.example.ego.server;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ego.entity.Good;
import com.example.ego.mapper.GoodMapper;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Author: Xuuxxi
 * @Date: 2022/3/26
 */
public class GoodServerImpl implements GoodServer{
    @Resource
    GoodMapper goodMapper;

    @Transactional
    @Override
    public Page<Good> getGoodsList(Integer pageNum, Integer pageSize, String category) {
        return goodMapper.selectPage(new Page<>(pageNum, pageSize), Wrappers.<Good>lambdaQuery().eq(Good::getCategory, category));
    }

    @Transactional
    @Override
    public Good getGood(String sellerName, Integer userId) {
        return goodMapper.selectOne(Wrappers.<Good>lambdaQuery().eq(Good::getSellerName,sellerName));
    }

    @Transactional
    @Override
    public Good getGood(Integer goodId, Integer userId) {
        return goodMapper.selectOne(Wrappers.<Good>lambdaQuery().eq(Good::getId,goodId));
    }
}
