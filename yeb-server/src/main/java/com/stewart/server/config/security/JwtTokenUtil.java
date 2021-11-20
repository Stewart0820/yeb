package com.stewart.server.config.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Stewart
 * @create 2021/11/20
 */
@Component
public class JwtTokenUtil {
    private static final String CLIAIM_KEY_USERNAME = "sub";

    //创建时间
    private static final String CLIAIM_KEY_CREATE = "created";

    @Value("${jwt.secret}")
    private String secret;


    @Value("${jwt.expiration}")
    private Long expiration;

    /**
     * 根据用户信息生成token
     *
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(CLIAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLIAIM_KEY_CREATE, new Date());
        return generateToken(claims);
    }

    /**
     * 根据负载生成JWT token
     *
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.ES256, secret)
                .compact();
    }

    /**
     * 生成token的过期时间
     * @return
     */
    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    /**
     * 从token中获取登录用户名
     * @param token
     * @return
     */
    public String getUserNameFromToken(String token){
        String username;
        //获取荷载
        try {
            //通过解密后的claims获取信息
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username=null;
        }
        return username;
    }

    /**
     * 也就是解密获取claims  token
     * 从token获取荷载
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
            .setSigningKey(secret)
            .parseClaimsJws(token)
            .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 验证token是否有效（时间+username）
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token,UserDetails userDetails){
        String username = getUserNameFromToken(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * 判断token是否有效（时间）
     * @param token
     * @return
     */
    private boolean isTokenExpired(String token) {
        Date expireDate = getExpiredDateFromToken(token);
        //判断是否在当前时间前面
        return expireDate.before(new Date());
    }

    /**
     * 从token中获取失效时间
     * @param token
     * @return
     */
    private Date getExpiredDateFromToken(String token) {
        //解析token，获取荷载
        Claims claims = getClaimsFromToken(token);
        return claims.getExpiration();
    }

}
