package br.com.training.cleanarch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"br.com.training.cleanarch.gateway"})
@EntityScan(basePackages = {"br.com.training.cleanarch.domain"})
@ComponentScan(basePackages = {"br.com.training.cleanarch"})
public class CleanarchApplication{
    public static void main(String[] args) {
        SpringApplication.run(CleanarchApplication.class, args);
    }
}
