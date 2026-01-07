package com.PocketIdentityDirectory.feign;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Configuration
public class BasicAuthConfig {

    @Value("${ias.id}")
    private String clientId;

    @Value("${ias.secret}")
    private String clientSecret;

    @Bean
    public RequestInterceptor basicAuthInterceptor() {
        return requestTemplate -> {
            String auth = clientId + ":" + clientSecret;
            String encodedAuth = Base64.getEncoder()
                    .encodeToString(auth.getBytes(StandardCharsets.UTF_8));
            requestTemplate.header("Authorization", "Basic " + encodedAuth);
        };
    }
}
