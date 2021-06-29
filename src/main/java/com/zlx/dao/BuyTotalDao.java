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
    @Insert("INSERT INTO buytotal(uid,salesMoney,payMoney,changeMoney,adminid) VALUES (#{uid},#{salesMoney},#{payMoney},#{changeMoney},#{adminid})")
    @Options(useGeneratedKeys = true, keyProperty = "totalid")
    public Integer insertToBuyTotal (BuyTotal buyTotal);

    @Delete("delete from buytotal where totalid=#{totalid}")
    public Integer deleteBuyTotal(BuyTotal buyTotal);
}
