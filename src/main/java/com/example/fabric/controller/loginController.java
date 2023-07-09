package com.example.fabric.controller;//package com.example.fabric.controller;

import com.example.fabric.pojo.Result;
import com.example.fabric.pojo.user;
import com.example.fabric.service.UserService;
import com.example.fabric.utils.jwt;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class loginController {

    @Autowired
    private UserService userService;

    //登陆操作
    @PostMapping("/login")
    public Result login(@RequestBody user usr){
        log.info("用户登录：{}",usr);
        user u = userService.login(usr);

        //登录成功，生成令牌
        if(u!=null) {
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",u.getId());
            claims.put("name",u.getName());
            claims.put("username",u.getUsername());
            String jwts = jwt.genJwt(claims); //jwt包涵当前登录员工信息
            return Result.success(jwts);
        }

        //失败返回错误信息
        return Result.error("用户名或密码错误");
    }

    @RequestMapping("testHello")
    public String testHello(){
        System.out.println("hello");
        return "hello";
    }

}
