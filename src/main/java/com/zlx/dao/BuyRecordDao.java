package com.zlx.dao;

import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.BuyTotal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BuyRecordDao {

    @Insert("insert into buyrecord(totalid,gid,buyAmount) values(#{totalid},#{gid},#{buyAmount})")
    public Integer insertToBuyRecord(BuyRecord buyRecord);

    @Delete("delete from buyrecord where totalid=#{totalid}")
    public Integer deleteBuyRecord(BuyTotal buyTotal);
}
