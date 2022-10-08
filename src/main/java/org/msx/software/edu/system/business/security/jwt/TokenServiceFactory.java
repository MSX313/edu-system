package org.msx.software.edu.system.business.security.jwt;

import org.springframework.security.authentication.AuthenticationManager;

import javax.crypto.SecretKey;

public interface TokenServiceFactory {

    TokenService getInstance(SecretKey secretKey, JwtProvider jwtProvider, AuthenticationManager authenticationManager);
}