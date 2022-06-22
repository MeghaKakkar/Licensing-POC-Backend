package com;

import com.repository.LicenceRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication()
@EnableMongoRepositories("com.repository")
@ComponentScan("com.*")
public class AppStartup {

    public static void main(String[] args) {
        SpringApplication.run(AppStartup.class, args);
    }
}
