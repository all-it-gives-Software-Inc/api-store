package com.example.storemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StoreMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreMicroserviceApplication.class, args);
    }

}
