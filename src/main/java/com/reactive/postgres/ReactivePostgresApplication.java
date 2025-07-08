package com.reactive.postgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories
@SpringBootApplication(exclude = {R2dbcAutoConfiguration.class})
public class ReactivePostgresApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactivePostgresApplication.class, args);
	}

}
