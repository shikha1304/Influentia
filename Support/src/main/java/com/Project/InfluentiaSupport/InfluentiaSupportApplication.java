package com.Project.InfluentiaSupport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InfluentiaSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfluentiaSupportApplication.class, args);
	}

}
