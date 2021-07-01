package com.zlx.dao;

import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.BuyTotal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BuyRecordDao {

    public Integer insertToBuyRecord(BuyRecord buyRecord);

    public Integer deleteBuyRecord(BuyTotal buyTotal);


}
