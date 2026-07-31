package com.back.p_62_260730;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class P62260730Application {


	public static void main(String[] args) {

		SpringApplication.run(P62260730Application.class, args);

	}

}
