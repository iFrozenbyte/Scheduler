package ru.petproject.shedulerconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ShedulerConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShedulerConfigApplication.class, args);
	}

}
