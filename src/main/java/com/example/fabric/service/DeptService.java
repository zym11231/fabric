package com.example.fabric.service;

import com.example.fabric.pojo.pageBean;
import com.example.fabric.pojo.shops;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DeptService {

    void Sdelete(Integer id);

    void Sadd(shops shop);

    pageBean page(Integer page, Integer pageSize);
}
