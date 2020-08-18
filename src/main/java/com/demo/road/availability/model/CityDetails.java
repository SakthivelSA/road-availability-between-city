package com.demo.road.availability.model;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CityDetails {
    private Map<String, String> cityMap;

    /**
     * This constructor gets initiated via configuration - After reading the file which contains city details
     *
     * @param cityMap
     */
    public CityDetails(Map<String, String> cityMap) {
        this.cityMap = cityMap;
    }

    /**
     * Return the has map which contains the Origin and Destination
     *
     * @return Map<String, String>
     */
    public Map<String, String> getCityMap() {
        return this.cityMap;
    }
}
