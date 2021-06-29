package com.zlx.service;

import com.github.pagehelper.PageInfo;
import com.zlx.pojo.Admin;
import com.zlx.pojo.User;

import java.util.Map;

public interface UserService {
    //添加用户/vip
    public Integer addUser(User user);
    //根据用户卡号删除用户
    public Integer deleteUserById(User user);
    //查询所有用户
    public PageInfo<User> queryAllUser(int page, int limit);
    //根据条件查询 用户
    public PageInfo<User> queryUserByCondition(User user, int page, int limit);
    //更新用户积分
    public Integer updateIntegral(Map<String,Object> param);

    //更新用户信息
    public Integer updateUserInfo(User user);

    public Integer queryIdCardCount(User user);



}
