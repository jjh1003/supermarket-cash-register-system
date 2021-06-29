package com.zlx.controller;

import com.github.pagehelper.PageInfo;
import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.Goods;
import com.zlx.pojo.TableData;
import com.zlx.pojo.User;
import com.zlx.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class GoodsController {
    /**
     * 根据条件查询商品，显示到表格中
     */
    @Autowired
    private GoodsService goodsService;
    @ResponseBody
    @RequestMapping("/queryAllGoodsByCondition")
    public TableData QueryGoodsByConditionList(Goods goods, int page, int limit){

        PageInfo<Goods> goodsPageInfo = goodsService.queryGoodsByCondition(goods,page, limit);
        TableData tableData=new TableData();
        tableData.setCode(0);
        tableData.setMsg("成功");
        tableData.setCount(goodsPageInfo.getTotal());//总条数
        tableData.setData(goodsPageInfo.getList());//设置当前的数据
        List<Goods> list = goodsPageInfo.getList();
        //model.addAttribute("goods",list.get(0));
        return tableData;
    }

    /**
     * 根据货物编号查询货物，最终结果是显示到label中
     */

    @ResponseBody
    @RequestMapping("/queryGoodsByNo")
    public Goods  queryGoodsByNo(Goods goods, Model model){

        Goods goods1 = goodsService.queryGoodsByNo(goods);
        model.addAttribute("goods",goods1);
        return goods1;

    }

    /**
     * 初始化收银页面物品编号下拉选择框获取所有商品的编号
     */


    @RequestMapping("/queryAllGoods")
    public String QueryGoodsList(Model model) {
        List<Goods> goodsList = goodsService.queryAllGoods();
        model.addAttribute("goodsList", goodsList);
        return "/cashier/cashRegister";
    }

    @RequestMapping("/deleteGoods")
    @ResponseBody
    public String deleteGoodsById(@RequestBody List<Goods> goodsList){
        if (goodsList!=null) {
            int i=0;
            for (Goods goods : goodsList) {
                Integer count = goodsService.deleteGoodsById(goods);
                if (count > 0) {
                    i++;
                    if (i==goodsList.size()){
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
    @ResponseBody
    @RequestMapping("/updateGoods")
    public String updateGoods(@RequestBody Goods goods){

        Integer integer = goodsService.updateGoods(goods);
        if (integer>0){
            return "更新成功";
        }else {
            return "更新失败";
        }
    }
    @ResponseBody
    @RequestMapping("/insertGoods")
    public String insertGoods(@RequestBody Goods goods){

        Integer count = goodsService.queryGoodsNoCount(goods);
        if (count>0){
            return "该商品编号已存在";
        }
        Integer integer = goodsService.insertGoods(goods);
        if (integer>0){
            return "添加成功";
        }else {
            return "添加失败";
        }
    }

    @ResponseBody
    @RequestMapping("/decreaseGoodsStock")
    public String decreaseGoodsStock(@RequestBody List<BuyRecord> recordList){

        if (recordList != null) {
            for (BuyRecord buyRecord : recordList) {
                if (buyRecord!=null){
                    int integer=goodsService.decreaseGoodsStock(buyRecord);

                }
            }
        }
            return "数据为空";

    }
}
