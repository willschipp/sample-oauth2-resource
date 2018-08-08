package com.example.telco;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@SpringBootApplication
@EnableResourceServer
public class Application {

    public static void main(String... args) throws Exception {
        SpringApplication.run(Application.class,args);
    }

    @Value("${security.checkpointUrl}")
    private String checkPointUrl;

    @Value("${security.client-id}")
    private String clientId;

    @Value("${security.client-secret}")
    private String clientSecret;

    @Primary
    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(checkPointUrl);
        tokenService.setClientId(clientId);
        tokenService.setClientSecret(clientSecret);
        return tokenService;
    }
}
