package com.zlx.dao;

import com.zlx.pojo.BuyRecord;
import com.zlx.pojo.Goods;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GoodsDao {
    //根据条件查询物品
    String QUERY_CODE_SQL = "<if  test= \"gNo != null and gNo != ''\"> AND gNo LIKE CONCAT(CONCAT('%',#{gNo}),'%')</if> " +
            "<if  test= \"gName != null and gName != ''\">  AND gName LIKE CONCAT(CONCAT('%',#{gName}),'%')</if>" +
            "<if  test= \"isBargainPrice != null and isBargainPrice != ''\">  AND isBargainPrice=#{isBargainPrice} </if>";

    @Select("<script>select * from goods where 1=1"+QUERY_CODE_SQL+"</script>" )
    public List<Goods> queryGoodsByCondition(Goods goods);

    //根据商品编号查询商品
    @Select("select * from goods where gNo=#{gNo}")
    public Goods queryGoodsByNo(Goods goods);

    //查询所有商品
    @Select("select * from goods" )
    public List<Goods> queryAllGoods();

    @Delete("delete from goods where gid=#{gid}")
    public Integer deleteGoodsById(Goods goods);

    @Update("update goods set gNo=#{gNo},gName=#{gName},price=#{price},isBargainPrice=#{isBargainPrice},bargainPrice=#{bargainPrice},unit=#{unit},stock=#{stock} where gid=#{gid}")
    public Integer updateGoods(Goods goods);

    @Insert("insert into goods(gNo,gName,price,isBargainPrice,bargainPrice,unit,stock) values(#{gNo},#{gName},#{price},#{isBargainPrice},#{bargainPrice},#{unit},#{stock})")
    public Integer insertGoods(Goods goods);

    @Select("select count(*) from goods where gNo=#{gNo}")
    public Integer queryGoodsNoCount(Goods goods);

    //减少库存
    @Update("update goods set stock=stock-#{buyAmount} where gid=#{gid}")
    public Integer decreaseGoodsStock(BuyRecord buyRecord);
}
