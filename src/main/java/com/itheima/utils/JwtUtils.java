package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类
 */
public class JwtUtils {

    private static final String SIGN_KEY = "aXRoZWltYQ=="; // 签名密钥
    private static final long EXPIRE_TIME = 12 * 3600 * 1000; // 过期时间：12小时

    /**
     * 生成 JWT 令牌
     *
     * @param claims 自定义数据 Map
     * @return JWT 字符串
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, SIGN_KEY) // 指定加密算法和密钥
                .addClaims(claims) // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) // 设置过期时间
                .compact(); // 生成令牌
    }

    /**
     * 解析 JWT 令牌
     *
     * @param token JWT 字符串
     * @return Claims 对象，包含负载信息
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGN_KEY) // 设置签名密钥
                .parseClaimsJws(token) // 解析令牌
                .getBody(); // 获取负载部分
    }
}
