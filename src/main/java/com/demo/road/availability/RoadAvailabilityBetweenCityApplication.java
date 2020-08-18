package com.demo.road.availability;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.road.availability.*")
public class RoadAvailabilityBetweenCityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoadAvailabilityBetweenCityApplication.class, args);
    }

}
