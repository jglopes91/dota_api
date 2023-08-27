package com.joaogabriel.dotaApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableKafka
public class DotaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DotaApiApplication.class, args);
	}

}
