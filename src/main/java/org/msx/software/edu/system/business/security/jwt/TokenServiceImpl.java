package org.msx.software.edu.system.business.security.jwt;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.msx.software.edu.system.business.common.codes.ExceptionMessageCode;
import org.msx.software.edu.system.business.operation.authentication.UserManagementService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.crypto.SecretKey;

@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {

    private final SecretKey secretKey;
    private final JwtProvider jwtProvider;
    private final AuthenticationManager authenticationManager;

    public Authentication authenticate(String username) {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                            username, UserManagementService.DEFAULT_PASSWORD));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return authentication;
        } catch (AuthenticationException ex) {
            throw new SecurityException(ExceptionMessageCode.AUTHENTICATION_FAILED, ex);
        }
    }

    @Override
    public void authenticate(Claims body) {
        authenticate(body.getSubject());
    }

    @Override
    public String getToken(Authentication authentication) {
        return jwtProvider.jwtToken(authentication);
    }

    @Override
    public String refreshToken(String token) {
        Jws<Claims> claimsJws = pars(token);
        Claims body = claimsJws.getBody();
        String username = body.getSubject();
        Authentication authentication = authenticate(username);
        return jwtProvider.jwtToken(authentication);
    }

    @Override
    public Jws<Claims> pars(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(token);
        } catch (ExpiredJwtException e) {
            throw new SecurityException(ExceptionMessageCode.TOKEN_EXPIRED);
        } catch (JwtException e) {
            throw new SecurityException(ExceptionMessageCode.TOKEN_INVALID);
        }
    }
}
