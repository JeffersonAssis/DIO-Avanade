package com.dio.concerssionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConcerssionariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcerssionariaApplication.class, args);
	}

}
