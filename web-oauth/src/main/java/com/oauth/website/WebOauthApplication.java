package com.oauth.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class WebOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebOauthApplication.class, args);
	}

}
