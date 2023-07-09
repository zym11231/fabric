package com.example.fabric.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.fabric.pojo.Result;
import com.example.fabric.utils.jwt;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
//@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override //返回true，放行
    public boolean preHandle(HttpServletRequest req, HttpServletResponse rep, Object handler) throws Exception {

        //获取url
        String url = req.getRequestURL().toString();
        log.info("url为:{}",url);

        //判断url是否为登录（login），是则放行
        if(url.contains("login")){
            log.info("登录，放行");
            return true;
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
            return false;
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
            return false;
        }

        //放行
        log.info("jwt解析成功");
        return true;
    }

    @Override //目标资源方法运行后运行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("post...");
        //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override //视图渲染结束后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("after...");
        // HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
