package com.demo.road.availability.controller;

import com.demo.road.availability.service.CityConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class CityConnectorController {

    @Autowired
    private CityConnectorService cityConnectorService;

    @GetMapping(value = "connected")
    public String isGivenCitiesConnected(@RequestParam String origin, @RequestParam String destination) {
        return cityConnectorService.isCityConnected(origin, destination);
    }
}
