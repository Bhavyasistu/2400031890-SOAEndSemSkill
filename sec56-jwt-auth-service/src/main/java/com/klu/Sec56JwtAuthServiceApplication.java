package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class Sec56JwtAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sec56JwtAuthServiceApplication.class, args);
	}

}
