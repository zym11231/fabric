package com.example.fabric.pojo;

import jdk.jfr.Unsigned;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor //无参构造
@AllArgsConstructor//全参构造
public class user {
    private Integer id;//id号
    private String username;//用户名
    private String name;//姓名
    private Integer age;
    private Short gender;//1，男；2，女
    private Integer vip;//等级
    private String password;//密码
    private String phone;//手机号
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;
    private String image;//头像url
    //private address add;//收货地址
    private Integer role;

}
