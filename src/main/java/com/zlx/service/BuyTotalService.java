package com.zlx.service;

import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyTotal;
import com.zlx.pojo.User;

public interface BuyTotalService {
    //首先插入用户id到表buyTotal
    public Integer insertToBuyTotal( BuyTotal buyTotal);

    public Integer deleteBuyTotal(BuyTotal buyTotal);

    public Double salesTotal(Admin admin);
    public Integer totalIdCount(Admin admin);
    public Double allSalesTotal();
    public Integer allTotalIdCount();

}
