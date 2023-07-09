package com.example.fabric.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class jwt {

    private static String signKey="fabric";
    private static Long expire = 43200000L;

    //生成jwt令牌
    public static String genJwt(Map<String,Object> claims){
        //Map<String, Object> claims = new HashMap<>();
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,signKey) //签名算法
                .setClaims(claims) //设置内容
                .setExpiration(new Date(System.currentTimeMillis()+expire))//有效期为1h
                .compact();
        return jwt;
    }

    public static Claims parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
