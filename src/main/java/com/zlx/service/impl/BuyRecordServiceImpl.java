package com.zlx.service.impl;

import com.zlx.dao.BuyRecordDao;
import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.BuyTotal;
import com.zlx.service.BuyRecordService;
import com.zlx.service.BuyTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyRecordServiceImpl implements BuyRecordService {
    @Autowired
    private BuyRecordDao buyRecordDao;

    @Override
    public Integer insertToBuyRecord(BuyRecord buyRecord) {

        return buyRecordDao.insertToBuyRecord(buyRecord);
    }

    @Override
    public Integer deleteBuyRecord(BuyTotal buyTotal) {
        return buyRecordDao.deleteBuyRecord(buyTotal);
    }
}
