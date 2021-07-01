package com.zlx.service.impl;

import com.zlx.dao.BuyTotalDao;
import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyTotal;
import com.zlx.pojo.User;
import com.zlx.service.BuyTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyTotalServiceImpl implements BuyTotalService {
    @Autowired
    private BuyTotalDao buyTotalDao;
    @Override
    public Integer insertToBuyTotal(BuyTotal buyTotal) {

        return buyTotalDao.insertToBuyTotal( buyTotal);
    }

    @Override
    public Integer deleteBuyTotal(BuyTotal buyTotal) {
        return buyTotalDao.deleteBuyTotal(buyTotal);
    }
    @Override
    public Double salesTotal(Admin admin) {

        return buyTotalDao.salesTotal(admin);
    }

    @Override
    public Integer totalIdCount(Admin admin) {
        return buyTotalDao.totalIdCount(admin);
    }

    @Override
    public Double allSalesTotal() {
        return buyTotalDao.allSalesTotal();
    }

    @Override
    public Integer allTotalIdCount() {
        return buyTotalDao.allTotalIdCount();
    }
}
