package com.example.fabric.service.utml;

import com.example.fabric.mapper.UserMapper;
import com.example.fabric.pojo.user;
import com.example.fabric.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//@Component //将实现类交给IOC容器，控制反转
@Service
public class UserServiceImpl implements UserService {

    @Autowired //依赖注入
    private UserMapper userMapper;
    @Override
    public user login(user usr) {
        return userMapper.getup(usr);
    }

}