package com.blog.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BlogGetawayApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogGetawayApplication.class, args);
	}

}
