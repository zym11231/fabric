package com.example.fabric.service.utml;

import com.example.fabric.mapper.DeptMapper;
import com.example.fabric.pojo.Result;
import com.example.fabric.pojo.pageBean;
import com.example.fabric.pojo.shops;
import com.example.fabric.service.DeptService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceItml implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public void Sdelete(Integer id) {
        deptMapper.deleteId(id);
    }


    @Override
    public void Sadd(shops shop) {
        shop.setCreateTime(LocalDateTime.now());
        shop.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(shop);
    }

    @Override
    public pageBean page(Integer page, Integer pageSize) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //查询
        List<shops> shopsList= deptMapper.shopslist();
        Page<shops> p = (Page<shops>) shopsList;
        //封装pageBean
        pageBean pb = new pageBean(p.getTotal(),p.getResult());
        return pb;
    }

}
