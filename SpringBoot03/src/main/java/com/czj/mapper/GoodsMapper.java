package com.czj.mapper;

import com.czj.pojo.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsMapper {

    /**
     * @return  查询到的所有商品list集合
     * */
    List<Goods> queryAllGoods() ;
}
