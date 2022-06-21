package com;

import com.repository.LicenceRepository;
import com.service.LicenceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan(basePackageClasses = LicenceService.class)
@EnableJpaRepositories(basePackageClasses = {LicenceRepository.class})

public class AppStartup {

    public static void main(String[] args) {
        SpringApplication.run(AppStartup.class, args);
    }
}
