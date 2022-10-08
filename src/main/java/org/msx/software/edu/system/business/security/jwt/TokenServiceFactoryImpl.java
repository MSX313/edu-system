package org.msx.software.edu.system.business.security.jwt;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@Component
public class TokenServiceFactoryImpl implements TokenServiceFactory {

    @Override
    public TokenService getInstance(
            SecretKey secretKey, JwtProvider jwtProvider, AuthenticationManager authenticationManager) {
        return new TokenServiceImpl(secretKey, jwtProvider, authenticationManager);
    }
}