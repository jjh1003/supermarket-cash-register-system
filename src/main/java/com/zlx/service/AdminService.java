package com.zlx.service;

import com.github.pagehelper.PageInfo;
import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyTotal;
import com.zlx.pojo.User;

import java.util.Map;

public interface AdminService {
    //登录管理员/收银员账号
    public Admin findAdmin(Admin admin);
    //修改密码
    public Integer updatePassword(String newPassword,String username);

    public PageInfo<Admin> queryAllRecordByCondition(Map<String,String> param, int page, int limit);

    public PageInfo<Admin> queryAdminByCondition(Admin admin,int page, int limit);
    public Integer deleteAdminById(Admin admin);
    public Integer insertAdmin(Admin admin);
    public Integer queryAdminCount(Admin admin);


}
