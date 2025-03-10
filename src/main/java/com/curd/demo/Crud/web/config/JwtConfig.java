package com.curd.demo.Crud.web.config;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Setter
@ConfigurationProperties(prefix = "security.jwt")
public class JwtConfig {

    private String secretKey;
    private Long expirationTime;

    public String getSecretKey() {
        return secretKey;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }
}
