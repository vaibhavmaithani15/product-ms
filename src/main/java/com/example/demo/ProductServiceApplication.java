package com.example.demo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
@EnableEurekaClient
public class ProductServiceApplication {
	public static void main(String[] args) {
		 ApplicationContext context=SpringApplication.run(ProductServiceApplication.class, args);


	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	

}
