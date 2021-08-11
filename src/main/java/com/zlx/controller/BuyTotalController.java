package com.zlx.controller;

import com.zlx.pojo.Admin;
import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.BuyTotal;
import com.zlx.pojo.User;
import com.zlx.service.BuyRecordService;
import com.zlx.service.BuyTotalService;
import com.zlx.service.GoodsService;
import com.zlx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller

public class BuyTotalController {

    @Autowired
    private BuyTotalService buyTotalService;
    @Autowired
    private BuyRecordService buyRecordService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

    private int totalid;

    @RequestMapping("/insertToBuyTotal")
    @ResponseBody
    public String insertToBuyTotal(BuyTotal buyTotal) {
        Integer buyTotal1Account = buyTotalService.insertToBuyTotal(buyTotal);
        totalid = buyTotal.getTotalid();
        System.out.println(totalid);
        Map<String,Object> param = new HashMap<>();
        param.put("uid",buyTotal.getUid());
        param.put("integral",buyTotal.getSalesMoney());
        //更新用户积分
        userService.updateIntegral(param);
        if (buyTotal1Account > 0) {
            return "结算成功";
        }
        return "结算失败";

    }


    @ResponseBody
    @RequestMapping("/insertBuyRecord")
    public String insertBuyRecord(@RequestBody List<BuyRecord> recordList) {
        System.out.println(totalid);
        System.out.println(recordList);
        Integer integer = 0;
        if (recordList != null) {
            for (BuyRecord buyRecord : recordList) {
                if (buyRecord!=null){
                    buyRecord.setTotalid(totalid);
                    integer = buyRecordService.insertToBuyRecord(buyRecord);
                    //goodsService.decreaseGoodsStock(buyRecord);
                }
            }
            if (integer > 0) {
                return "结算成功";
            } else {
                return "结算失败";
            }
        }

        return "无数据";
    }


}
