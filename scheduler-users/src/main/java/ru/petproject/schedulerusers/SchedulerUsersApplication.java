package ru.petproject.schedulerusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"ru.petproject.commonentitiesfordifferentms.entity", "ru.petproject.schedulerusers"})
@EnableJpaRepositories(basePackages = "ru.petproject.schedulerusers")
@EntityScan(basePackages = {"ru.petproject.commonentitiesfordifferentms.entity"})
public class SchedulerUsersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerUsersApplication.class, args);
    }

}
