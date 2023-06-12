package com.example.eurekaclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientsApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaClientsApplication.class, args);
	}

}
