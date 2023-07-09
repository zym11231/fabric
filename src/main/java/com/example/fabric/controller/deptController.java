package com.example.fabric.controller;

import com.example.fabric.pojo.Result;
import com.example.fabric.pojo.pageBean;
import com.example.fabric.pojo.shops;
import com.example.fabric.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class deptController {

    @Autowired
    private DeptService deptService;


    //删除商品
    @DeleteMapping("/depts/{id}")
    public Result Sdelete(@PathVariable Integer id){
        log.info("删除{}号商品",id);
        deptService.Sdelete(id);
        return Result.success();
    }

    //添加商品
    @PostMapping("/depts")
    public Result Sadd(@RequestBody shops shop){
        log.info("新增商品");
        deptService.Sadd(shop);
        return Result.success();
    }


    //分页查询商品
    @GetMapping("/shops")
    public Result pages(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize){
        log.info("分页查询{},{}",page,pageSize);
        pageBean pb = deptService.page(page,pageSize);
        return Result.success(pb);
    }
}
