package com.example.fabric.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.fabric.pojo.Result;
import com.example.fabric.utils.jwt;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@Component
//@WebFilter(urlPatterns = "/*")
public class Filterd implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse rep = (HttpServletResponse)servletResponse;

        //获取url
        String url = req.getRequestURL().toString();
        log.info("url为:{}",url);

        //判断url是否为登录（login），是则放行
        if(url.contains("login")){
            log.info("登录，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //不是登录操作获取token（jwt）
        String jwts = req.getHeader("token");

        //判断令牌（jwt）是否存在
        if(!StringUtils.hasLength(jwts)){
            log.info("token为空，未登录信息");
            Result error = Result.error("NOT_LOGIN");
            //转换为json
            String notLogin = JSONObject.toJSONString(error);
            rep.getWriter().write(notLogin);
            return;
        }

        //令牌存在，校验
        try {
            jwt.parseJwt(jwts);
        } catch (Exception e) { // 抛出异常证明解析失败
            e.printStackTrace();

            log.info("解析失败");
            Result error = Result.error("NOT_LOGIN");
            //转换为json
            String notLogin = JSONObject.toJSONString(error);
            rep.getWriter().write(notLogin);
            return;
        }

        //放行
        log.info("jwt解析成功");
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
