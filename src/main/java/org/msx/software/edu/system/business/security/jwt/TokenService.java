package org.msx.software.edu.system.business.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import org.springframework.security.core.Authentication;

public interface TokenService {

    Authentication authenticate(String username);

    void authenticate(Claims body);

    String getToken(Authentication authentication);

    String refreshToken(String token);

    Jws<Claims> pars(String token);
}