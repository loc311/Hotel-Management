/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hotel.backend.jwtconfig;

import com.hotel.backend.service.impl.UserDetailImpl;
import io.jsonwebtoken.*;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 *
 * @author macos
 */
@Component
public class JwtTokenProvider {
    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final String JWT_SECRET = "myToken";

    //Thời gian có hiệu lực của chuỗi jwt
    private final long JWT_EXPIRATION = 604800000L;
    private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

    // Tạo ra jwt từ thông tin user
    public String generateJwtToken(Authentication authentication) {
        UserDetailImpl userPrinciple = (UserDetailImpl)authentication.getPrincipal();
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(userPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + JWT_EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    // Lấy thông tin user từ jwt
//    public int getUserIdFromJWT(String token) {
//        Claims claims = Jwts.parser()
//                            .setSigningKey(JWT_SECRET)
//                            .parseClaimsJws(token)
//                            .getBody();
//        return Integer.parseInt(claims.getSubject());
//    }
    
    public String getEmailFromJwtToken(String token) {
        return Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
