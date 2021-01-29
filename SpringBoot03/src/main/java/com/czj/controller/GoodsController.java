package com.czj.controller;

import com.czj.pojo.Goods;
import com.czj.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("queryAllGoods")
    public List<Goods> queryAllGoods(){
        List<Goods> goods = goodsService.queryAllGoods();
        System.out.println(goods);
        return goods;
    }

}
