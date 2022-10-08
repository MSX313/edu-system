package org.msx.software.edu.system.business.security.jwt;


import com.google.common.net.HttpHeaders;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Component
@ConfigurationProperties(prefix = "application.jwt")
public class JwtConfig {

    private String secretKey;
    private String tokenPrefix;
    private Long tokenExpirationSecond;

    public JwtConfig() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getTokenPrefix() {
        return tokenPrefix != null ? tokenPrefix.trim().concat(" ") : null;
    }

    public Long getTokenExpirationSecond() {
        return tokenExpirationSecond;
    }

    public String getAuthorizationHeader() {
        return HttpHeaders.AUTHORIZATION;
    }
}

