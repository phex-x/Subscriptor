package com.subscriptor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    private String secret;
    private Long expiration;
    private String issuer;

    //getters
    public String getSecret() { return secret; }
    public long getExpiration() { return expiration; }
    public String getIssuer() { return issuer; }

    //setters
    public void setSecret(String secret) { this.secret = secret; }
    public void setExpiration(Long expiration) { this.expiration = expiration; }
    public void setIssuer(String issuer) { this.issuer = issuer; }
}
