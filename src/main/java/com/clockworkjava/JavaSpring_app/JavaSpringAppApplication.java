package com.clockworkjava.JavaSpring_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@PropertySource("classpath:castle.properties")
@EnableScheduling
public class JavaSpringAppApplication {

	public static void main(String[] args) {

        SpringApplication.run(JavaSpringAppApplication.class, args);

	}
}
