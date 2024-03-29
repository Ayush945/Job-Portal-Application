package com.example.JobPortal.util;
import com.example.JobPortal.enums.RoleEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.*;
import java.util.function.Function;
@Service
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expirationTime}")
    private int expiry;

    public String getEmailFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public RoleEnum getRoleFromToken(String token) {
        ArrayList<String> roles = getAllClaimsFromToken(token).get("roles", ArrayList.class);
        return RoleEnum.valueOf(roles.get(0));
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).build().parseClaimsJws(token).getBody();

    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(String username, List<String> roles) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        return doGenerateToken(claims, username);
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        String secureKey=generateSecureKey(256);
        byte[] keyBytes= new byte[0];
        try {
            keyBytes = secureKey.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Problem in generating Token");
        }
        SecretKeySpec spec=new SecretKeySpec(keyBytes,"HmacSHA256");
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiry)).signWith(SignatureAlgorithm.HS256, keyBytes)
                .compact();
    }
    private String generateSecureKey(int keyLength){
        SecureRandom random=new SecureRandom();
        byte[] keyBytes=new byte[keyLength/8];
        random.nextBytes(keyBytes);
        return new String(keyBytes, StandardCharsets.UTF_8);
    }

    public Boolean validateToken(String token, String username) {
        final String usernameFromToken = getEmailFromToken(token);
        return (usernameFromToken.equals(username) && !isTokenExpired(token));
    }

    public String extractTokenFromRequest(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            return token.substring(7, token.length());
        }
        return null;
    }
}
