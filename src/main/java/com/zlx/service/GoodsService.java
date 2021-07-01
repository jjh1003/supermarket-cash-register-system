package com.zlx.service;

import com.github.pagehelper.PageInfo;
import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.Goods;

import java.util.List;

public interface GoodsService {
    //根据条件查询商品
    public PageInfo<Goods> queryGoodsByCondition(Goods goods, int page, int limit);
    //查询所有商品
    public List<Goods> queryAllGoods();
    //根据商品编号查询商品
    public Goods queryGoodsByNo(Goods goods);

    public Integer deleteGoodsById(Goods goods);
    //编辑商品
    public Integer updateGoods(Goods goods);
    //添加商品
    public Integer insertGoods(Goods goods);

    public Integer queryGoodsNoCount(Goods goods);

    public Integer decreaseGoodsStock(BuyRecord buyRecord);

    public Integer goodsCount();


}
