package com.example.fabric.mapper;

import com.example.fabric.pojo.shops;
import com.example.fabric.pojo.user;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据ID删除用户
    @Delete("delete from tb_user where id = #{id}")
    public void delete(Integer id);

    public void deleteid(List<Integer> ids);

    //登录
    @Select("select * from tb_user where username = #{username} and " +
            "password = #{password};")
    user getup(user usr);

    @Update("update tb_user set username = #{username},image    = #{image},update_time = #{updateTime},password = #{password} where id = #{id}")
    public void update(user usr);

    public void update2(user usr);

    @Select("select * from tb_user where id = #{id}")
    public user getusr(Integer id);



    // $拼接
//    @Select("select * from tb_user where name like '%${name}%' and gender=#{gender} " +
//            "order by create_time desc")
//    public List<user> list(String name,Short gender);

//    @Select("select * from tb_user where name like concat('%',#{name},'%') and gender=#{gender} " +
//            "order by create_time desc")
//    public List<user> list1(String name,Short gender);
//
//    public List<user> list2(String name,Short gender);

}
