package com.mashibing.msbdongbaocommonutil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @author 何水锋
 * @version 1.0
 * 少壮不努力 只有搬砖命
 * @create 2022-04-20 16:00
 */
public class JWTUtil {
    private static final String secret="asdasdhas";

    /**
     * 加密
     * @param subject
     * @return
     */
    public static String creatToken(String subject){
        String compact = Jwts.builder()
                .setSubject(subject)
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis()+1000*10))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
        return compact;
    }
    /**
     * 解密
     */
    public static String parseToken(String token){
        Claims signature = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return signature.getSubject();
    }

}
