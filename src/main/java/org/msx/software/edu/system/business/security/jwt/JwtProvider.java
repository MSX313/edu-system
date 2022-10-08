package org.msx.software.edu.system.business.security.jwt;

import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public String jwtToken(Authentication authentication) {
        return Jwts.builder()
                .setSubject(authentication.getName()).claim("authorities", authentication.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date(Timestamp.valueOf(LocalDateTime.now()
                        .plusSeconds(jwtConfig.getTokenExpirationSecond())).getTime())).signWith(secretKey).compact();
    }
}