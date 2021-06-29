package com.zlx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlx.dao.GoodsDao;
import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.Goods;
import com.zlx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public PageInfo<Goods> queryGoodsByCondition(Goods goods, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Goods> goodsList = goodsDao.queryGoodsByCondition(goods);
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goodsList);
        return goodsPageInfo;
    }

    @Override
    public List<Goods> queryAllGoods() {
        return goodsDao.queryAllGoods();
    }



    @Override
    public Goods queryGoodsByNo(Goods goods) {

        return goodsDao.queryGoodsByNo(goods);
    }

    @Override
    public Integer deleteGoodsById(Goods goods) {
        return goodsDao.deleteGoodsById(goods);
    }

    @Override
    public Integer updateGoods(Goods goods) {
        return goodsDao.updateGoods(goods);
    }

    @Override
    public Integer insertGoods(Goods goods) {
        return goodsDao.insertGoods(goods);
    }

    @Override
    public Integer queryGoodsNoCount(Goods goods) {
        return goodsDao.queryGoodsNoCount(goods);
    }

    @Override
    public Integer decreaseGoodsStock(BuyRecord buyRecord) {
        return goodsDao.decreaseGoodsStock(buyRecord);
    }
}
