package com.demo.road.availability.config;

import com.demo.road.availability.model.CityDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class ConnectorServiceConfig {

    @Bean(name = "cityDetailsCustom")
    public CityDetails getCityDetails() {
        Map<String, String> cityMap = new HashMap<>();
        try {
            //Read the file and place the origin and destination to the map
            File file = new File(getClass().getClassLoader().getResource("City.txt").getFile());
            Stream<String> stream=Files.lines(file.toPath());
            cityMap = stream.map(str -> str.split(","))
                    .collect(Collectors.toMap(str -> str[0], str -> str[1]));

        } catch (IOException e) {
        }

        return new CityDetails(cityMap);
    }

}
