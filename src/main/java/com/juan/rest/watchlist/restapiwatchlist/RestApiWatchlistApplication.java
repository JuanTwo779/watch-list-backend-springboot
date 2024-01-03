package com.juan.rest.watchlist.restapiwatchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestApiWatchlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiWatchlistApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() { //cross origins requests
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("*");
			}
		};
	}

}
