package com.example.fabric;

import com.example.fabric.mapper.UserMapper;
import com.example.fabric.pojo.user;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.*;

//@SpringBootTest
class FabricApplicationTests {

//    @Test
//    void contextLoads() {
//    }
    @Autowired
    private UserMapper userMapper;

//    @Test
//    public void testListUser(){
//        List<user> userList = userMapper.list();
//        userList.stream().forEach(user->{
//            System.out.println(user);
//        });
//    }

//    @Test
//    public void testDelete(){
//        userMapper.delete(1);
//    }
//
    @Test
    public void testUpdate(){
        user usr=new user();
        usr.setUpdateTime(LocalDateTime.now());
        usr.setUsername("qwqwqw");
        usr.setId(2);
        //usr.setVip(0);
        //usr.setPassword("13579");
        System.out.println(usr);

        userMapper.update(usr);
    }

    @Test
    public void testGetusr(){
        user usr= userMapper.getusr(2);
        System.out.println(usr);
    }

    @Test
    public void testdel(){
        List<Integer> ids= Arrays.asList(6,7);
        userMapper.deleteid(ids);
    }

//    @Test
//    public void testList(){
//        List<user> usr = userMapper.list2("y",null);
//        usr.stream().forEach(user -> {
//            System.out.println(user);
//        });
//    }

    //测试生成jwt
    @Test
    public void testjwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",1);
        claims.put("name","zym");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,"fabric") //签名算法
                .setClaims(claims) //设置内容
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))//有效期为1h
                .compact();
        System.out.println(jwt);
    }

    //解析jwt
    @Test
    public void testPjwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("fabric")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoienltIiwiaWQiOjEsImV4cCI6MTY4ODc0NDA2MH0.Pz30X19Xk-N-4TUP-ZP_HHTVsy5qL3kgyHp1SzC8d0k")
                .getBody();
        System.out.println(claims);
    }
}
