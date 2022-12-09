package com.sparta.projectmemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication

public class ProjectMemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMemoApplication.class, args);
    }

}
