package ru.petproject.schedulertasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"ru.petproject.commonentitiesfordifferentms.entity", "ru.petproject.schedulertasks"})
@EnableJpaRepositories(basePackages = "ru.petproject")
@EntityScan(basePackages = {"ru.petproject.commonentitiesfordifferentms.entity"})
public class SchedulerTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerTasksApplication.class, args);
    }
}