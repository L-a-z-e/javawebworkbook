package com.laze.bootex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BootexApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootexApplication.class, args);
    }

}
