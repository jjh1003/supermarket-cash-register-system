package com.zlx.controller;

import com.github.pagehelper.PageInfo;
import com.zlx.pojo.TableData;
import com.zlx.pojo.User;
import com.zlx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户（vip）
     * @param user
     * @return
     */
    @PostMapping("/addUser")
    @ResponseBody
    public String addUser(User user){

        Integer idCardCount = userService.queryIdCardCount(user);
        if (idCardCount>0){
            return "此卡号已存在";
        }
        if (userService.addUser(user)>0){
            return "添加成功";
        }

        return "添加失败";
    }

    /**
     * 删除用户/vip
     */

    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUserById( @RequestBody List<User> userList){

        if (userList!=null) {
            int i=0;
            for (User user : userList) {
                Integer count = userService.deleteUserById(user);
                if (count > 0) {
                    i++;
                    if (i==userList.size()){
                        return "删除成功";
                    }
                } else {
                    return "删除失败";
                }
            }
        }else {
            return "数据为空";
        }

        return "数据为空";
    }

    /**
     * 查询所有用户
     */

    @ResponseBody
    @RequestMapping("/queryAllUser")
    public TableData queryAllUser(int page, int limit){

        PageInfo<User> userPageInfo = userService.queryAllUser(page, limit);
        TableData tableData=new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(userPageInfo.getTotal());//总条数
        tableData.setData(userPageInfo.getList());//设置当前的数据
        return tableData;
    }

    /**
     * 根据条件查询用户/vip
     */

    @ResponseBody
    @RequestMapping("/queryUserByCondition")
    // @RequestParam(required = false,defaultValue = "1")
    //@RequestParam(required = false,defaultValue = "1")
    public TableData QueryGoodsByConditionList(User user, int page,int limit){

        PageInfo<User> userPageInfo = userService.queryUserByCondition(user,page, limit);
        TableData tableData=new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(userPageInfo.getTotal());//总条数
        tableData.setData(userPageInfo.getList());//设置当前的数据
        return tableData;
    }

    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUserInfo(@RequestBody User user){


        Integer integer = userService.updateUserInfo(user);
        if (integer>0){
            return "更新成功";
        }else {
            return "更新失败";
        }

    }
}
