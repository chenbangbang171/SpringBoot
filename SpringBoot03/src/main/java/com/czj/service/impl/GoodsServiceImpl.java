package com.czj.service.impl;

import com.czj.mapper.GoodsMapper;
import com.czj.pojo.Goods;
import com.czj.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }
}
