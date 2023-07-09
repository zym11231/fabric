package com.example.fabric.mapper;

import com.example.fabric.pojo.shops;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface DeptMapper {
    //按页查询商品信息
    @Select("select * from db02.tb_shoping")
    List<shops> shopslist();

    @Delete("delete from db02.tb_shoping where id=#{id}")
    void deleteId(Integer id);

    @Insert("insert into db02.tb_shoping(shop_name, price, shop_image, shops_id, type, number, create_time, update_time) " +
            "values(#{shopName},#{price},#{shopImage},#{shopsId},#{type},#{number},#{createTime},#{updateTime})")
    void insert(shops shop);

    //按页查询商品
//    @Select("select count(*) from db02.tb_shoping;") //查询总记录数
//    public Long count();
//
//    @Select("select * from db02.tb_shoping limit #{start},#{pageSize};")//获取列表数据
//    public List<shops> page(Integer start,Integer pageSize);
}
