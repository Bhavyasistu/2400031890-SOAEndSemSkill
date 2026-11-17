package com.klu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class Sec56JwtEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sec56JwtEurekaApplication.class, args);
	}

}
