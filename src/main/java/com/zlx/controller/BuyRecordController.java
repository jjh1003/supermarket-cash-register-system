package com.zlx.controller;

import com.zlx.pojo.BuyTotal;
import com.zlx.service.BuyRecordService;
import com.zlx.service.BuyTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BuyRecordController {
    @Autowired
    private BuyTotalService buyTotalService;
    @Autowired
    private BuyRecordService buyRecordService;
    @ResponseBody
    @RequestMapping("/deleteBuyRecord")
    public String deleteBuyRecord(BuyTotal buyTotal){

        if (buyTotal!=null){
            Integer integer = buyRecordService.deleteBuyRecord(buyTotal);
            if (integer>0){
                buyTotalService.deleteBuyTotal(buyTotal);
                return "删除成功";
            }else {
                return  "删除失败";
            }
        }
        return "数据为空";

    }
}
