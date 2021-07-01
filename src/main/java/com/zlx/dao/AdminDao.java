package com.zlx.dao;

import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyTotal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdminDao {
    public Admin findAdmin(Admin admin);

    public Integer UpdatePassword(@Param("newPassword") String newPassword, @Param("username") String username);
    //查询收银台的销售记录包括收银台账号，id，销售总记录的各项，用户卡号，商品等
    public List<Admin> queryAllRecordByCondition(Map<String,String> param);

    public List<Admin> queryAdminByCondition(Admin admin);
    public Integer deleteAdminById(Admin admin);
    public Integer insertAdmin(Admin admin);
    public Integer queryAdminCount(Admin admin);

    //统计超市收银员数量
    public Integer adminCount();
}
