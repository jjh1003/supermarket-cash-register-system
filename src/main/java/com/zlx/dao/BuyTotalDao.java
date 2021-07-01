package com.zlx.dao;

import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyTotal;
import com.zlx.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BuyTotalDao {
   // @Insert("INSERT INTO buytotal(uid,salesMoney,payMoney,changeMoney,adminid) VALUES (#{uid},#{salesMoney},#{payMoney},#{changeMoney},#{adminid})")
    //@Options(useGeneratedKeys = true, keyProperty = "totalid")
    public Integer insertToBuyTotal (BuyTotal buyTotal);

    public Integer deleteBuyTotal(BuyTotal buyTotal);

    //统计本收银台的销售额
    public Double salesTotal(Admin admin);
    //统计本收银台订单数
    public Integer totalIdCount(Admin admin);
    //统计所有收银台的销售额
   public Double allSalesTotal();
   //统计超市的总订单数
   public Integer allTotalIdCount();

}
