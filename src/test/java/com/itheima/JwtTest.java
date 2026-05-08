// 请帮我基于如下单元测试方法，改造成一个 JWT 令牌操作的工具类，类名：JwtUtils，具体要求如下：
// 1. 工具类中有两个方法，一个方法生成令牌，一个是解析令牌
// 2. 生成令牌时使用的密钥，和测试类中的一致即可
// 3. 令牌的过期时间设置12小时
package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    /**
     * 生成JWT令牌
     */
    @Test
    public void testGenerateJwt() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");

        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "aXRoZWltYQ==") // 指定加密算法，密钥
                .addClaims(dataMap) // 添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600*1000)) // 设置过期时间 1h
                .compact(); // 生成令牌
        System.out.println(jwt);
    }

    /**
     * 解析 JWT 令牌
     */
    @Test
    public void testParseJWT() {
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc3ODI1MzQzN30.sd3RYn-SGEKoxwBHCZ7p0TVhsgdBO2L3O_5Vw52eEg4";
        Claims claims = Jwts.parser().setSigningKey("aXRoZWltYQ==")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
