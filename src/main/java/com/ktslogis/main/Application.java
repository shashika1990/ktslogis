package com.ktslogis.main;

import com.ktslogis.controller.ContainerController;
import com.ktslogis.entity.Container;
import com.ktslogis.repository.ContainerRepository;
import com.ktslogis.service.ContainerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ContainerController.class, ContainerService.class, SecurityConfig.class})
@EntityScan(basePackageClasses = {Container.class})
@EnableJpaRepositories(basePackageClasses = {ContainerRepository.class})
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
