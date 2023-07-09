package com.example.fabric.service;

import com.example.fabric.pojo.pageBean;
import com.example.fabric.pojo.user;
import org.springframework.stereotype.Service;


public interface UserService {

    user login(user usr);

    //分页查询

}
