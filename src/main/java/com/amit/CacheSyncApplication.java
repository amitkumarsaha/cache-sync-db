package com.amit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CacheSyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheSyncApplication.class, args);
	}

}
