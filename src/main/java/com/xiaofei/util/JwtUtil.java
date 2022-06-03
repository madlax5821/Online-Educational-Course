package com.xiaofei.util;

import com.xiaofei.dto.JwtUser;
import com.xiaofei.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Author: xiaofei
 * Date: 2022-05-23, 20:22
 * Description:
 */

public class JwtUtil {
    private static final String TOKEN_HEADER = "Authorization";
    private static final String TOKEN_PREFIX = "Bearer ";
    
    public static final String SECRET = "xiaofeifei";
    public static final String ISSUER = "rockville";
    
    public static final Long EXPIRATION = 300L*1000;
    public static final Long EXPIRATION_REMEMBER_ME = 3600L*1000;
    
    public static String generateToken(JwtUser jwtUser, boolean ifRememberMe){
        long expiration = ifRememberMe?EXPIRATION_REMEMBER_ME:EXPIRATION;
        Map<String, Object> map = new HashMap<>();
        map.put("id",jwtUser.getId());
        map.put("username",jwtUser.getUsername());
        map.put("authority",jwtUser.getAuthorities());

        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512,SECRET)
                .setIssuer(ISSUER)
                .setClaims(map)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .compact();
    }
    
    public static Claims decryptToken(String token){
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
    
    public static Boolean ifExpired(String token){
        return decryptToken(token).getExpiration().before(new Date());
    }
    
    public static JwtUser parseTokenToJwtUser(String token){
        Claims claims = decryptToken(token);
        User user = new User();
        user.setId((Long) claims.get("id"));
        user.setUsername((String) claims.get("username"));
        List<LinkedHashMap<String, String>> rolesMap = (List<LinkedHashMap<String, String>>) claims.get("authority");
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        for (LinkedHashMap<String, String> role:rolesMap){
            authorities.add(new SimpleGrantedAuthority(role.get("authority")));
        }
        
        return new JwtUser(user,null,authorities);
    }
}
