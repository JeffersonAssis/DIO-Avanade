package com.dio.concessionaria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ConcessionariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConcessionariaApplication.class, args);
	}

}
