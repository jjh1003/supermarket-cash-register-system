package com.zlx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlx.dao.AdminDao;
import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyTotal;
import com.zlx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin findAdmin(Admin admin) {
        return adminDao.findAdmin(admin);
    }

    @Override
    public Integer updatePassword(String newPassword, String username) {
        return adminDao.UpdatePassword(newPassword,username);

    }


    @Override
    public PageInfo<Admin> queryAllRecordByCondition(Map<String,String> param, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Admin> adminList = adminDao.queryAllRecordByCondition(param);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(adminList);

        return adminPageInfo;
    }

    @Override
    public PageInfo<Admin> queryAdminByCondition(Admin admin, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<Admin> admins = adminDao.queryAdminByCondition(admin);
        PageInfo<Admin> adminPageInfo = new PageInfo<>(admins);

        return adminPageInfo;
    }

    @Override
    public Integer deleteAdminById(Admin admin) {
        return adminDao.deleteAdminById(admin);
    }

    @Override
    public Integer insertAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }

    @Override
    public Integer queryAdminCount(Admin admin) {
        return adminDao.queryAdminCount(admin);
    }
}
