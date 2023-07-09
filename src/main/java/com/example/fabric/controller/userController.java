package com.example.fabric.controller;

import com.example.fabric.mapper.UserMapper;
import com.example.fabric.pojo.Result;
import com.example.fabric.pojo.pageBean;
import com.example.fabric.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class userController {

    @Autowired
    private UserService userService;


}
