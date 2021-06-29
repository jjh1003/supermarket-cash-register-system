package com.zlx.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zlx.dao.UserDao;
import com.zlx.pojo.User;
import com.zlx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }


    @Override
    public Integer deleteUserById(User user) {
        return userDao.deleteUserById(user);
    }


    @Override
    public PageInfo<User> queryAllUser(int page, int limit) {
        PageHelper.startPage(page,limit);
        List<User> userList = userDao.queryAllUser();
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }


    @Override
    public PageInfo<User> queryUserByCondition(User user, int page, int limit) {
        PageHelper.startPage(page,limit);
        List<User> userList = userDao.queryUserByCondition(user);
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        return userPageInfo;
    }

    @Override
    public Integer updateIntegral(Map<String, Object> param) {
        return userDao.updateIntegral(param);
    }

    @Override
    public Integer updateUserInfo(User user) {
        return userDao.updateUserInfo(user);
    }

    @Override
    public Integer queryIdCardCount(User user) {
        return userDao.queryIdCardCount(user);
    }
}
