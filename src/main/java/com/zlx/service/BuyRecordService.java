package com.zlx.service;

import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.BuyTotal;

public interface BuyRecordService {

    public Integer insertToBuyRecord(BuyRecord buyRecord);
    public Integer deleteBuyRecord(BuyTotal buyTotal);

}
