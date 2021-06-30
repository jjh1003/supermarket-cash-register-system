package com.zlx.controller;

import com.github.pagehelper.PageInfo;
import com.zlx.pojo.*;
import com.zlx.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 登录管理员/收银员
     *
     * @param admin
     * @param model
     * @param session
     * @return
     */
    @PostMapping("/userLogin")
    public String Login(Admin admin, Model model, HttpSession session) {

        Admin admin1 = adminService.findAdmin(admin);
        session.setAttribute("admin", admin1);
        if (admin1!= null) {
            if (admin1.getIdentify().equals("管理员")) {
                return "redirect:/administrator";

            }
            if (admin1.getIdentify().equals("收银员")) {
                return "redirect:/cashier";
            }

        }
            model.addAttribute("msg", "密码错误");
            return "login";
    }

    /**
     * 退出登录
     *
     * @param session
     * @return
     */
    @RequestMapping("/signOut")
    public String signOut(HttpSession session) {
        //清除session
        session.invalidate();

        return "redirect:/login";
    }

    /**
     * 修改密码
     */

    @ResponseBody
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    public String updatePassword(String oldPassword, String newPassword, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");

        if (admin.getPassword().equals(oldPassword)) {
            Integer count = adminService.updatePassword(newPassword, admin.getUsername());
            if (count > 0) {
                session.invalidate();
                return "修改成功!";
            } else {
                return "更新失败";
            }
        } else {
            return "原密码错误";
        }

    }

    @ResponseBody
    @RequestMapping("/queryAllRecordByCondition")
    public TableData queryAllRecordByCondition(String username, String idCard, int page, int limit) {
        Map<String, String> param = new HashMap<>();
        param.put("username", username);
        param.put("idCard", idCard);
        PageInfo<Admin> adminPageInfo = adminService.queryAllRecordByCondition(param, page, limit);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(adminPageInfo.getTotal());//总条数
        tableData.setData(adminPageInfo.getList());//设置当前的数据
        List<Admin> list = adminPageInfo.getList();

        return tableData;
    }

    @ResponseBody
    @RequestMapping("/queryAdminByCondition")

    public TableData QueryGoodsByConditionList(Admin admin, int page, int limit) {

        PageInfo<Admin> adminPageInfo = adminService.queryAdminByCondition(admin, page, limit);
        TableData tableData = new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(adminPageInfo.getTotal());//总条数
        tableData.setData(adminPageInfo.getList());//设置当前的数据
        return tableData;
    }

    @ResponseBody
    @RequestMapping("/deleteAdminById")
    public String deleteAdminById(@RequestBody List<Admin> adminList) {
        if (adminList != null) {
            int i = 0;
            for (Admin admin : adminList) {
                Integer count = adminService.deleteAdminById(admin);
                if (count > 0) {
                    i++;
                    if (i == adminList.size()) {
                        return "删除成功";
                    }
                } else {
                    return "删除失败";
                }
            }
        } else {
            return "数据为空";
        }

        return "数据为空";
    }

    @ResponseBody
    @RequestMapping("/insertAdmin")
    public String insertAdmin(@RequestBody Admin admin) {

        Integer count = adminService.queryAdminCount(admin);
        if (count > 0) {
            return "该账号已存在";
        }
        Integer integer = adminService.insertAdmin(admin);
        if (integer > 0) {
            return "添加成功";

        } else {
            return "添加失败";
        }
    }
}
