package com.zlx.dao;

import com.zlx.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserDao {
    //根据用户id删除用户vip
    @Delete("delete from user where uid=#{uid}")
    public Integer deleteUserById(User user);
    //添加用户
    @Insert("insert into user(idCard,integral) value (#{idCard},#{integral})")
    public Integer addUser(User user);
    //查询所有用户
    @Select("select * from user")
    public List<User> queryAllUser();

    //根据条件查询用户
    String QUERY_CODE_SQL = "<if  test= \"idCard != null and idCard != ''\"> AND idCard LIKE CONCAT(CONCAT('%',#{idCard}),'%')</if> ";
    @Select("<script>select * from user where 1=1"+QUERY_CODE_SQL+"</script>" )
    public List<User> queryUserByCondition(User user);
    //更新用户积分
    @Update("update user set integral=integral+#{integral} where uid=#{uid}")
    public Integer updateIntegral(Map<String,Object> param);

    //修改用户信息
    @Update("update user set idCard=#{idCard},integral=#{integral} where uid=#{uid}")
    public Integer updateUserInfo(User user);

    @Select("select count(*) from user where idCard=#{idCard}")
    //查询卡号，如果存在则不能添加此卡号
    public Integer queryIdCardCount(User user);
}
