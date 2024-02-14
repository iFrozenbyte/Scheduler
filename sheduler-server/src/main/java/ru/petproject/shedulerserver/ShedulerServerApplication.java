package ru.petproject.shedulerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ShedulerServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShedulerServerApplication.class, args);
    }

}