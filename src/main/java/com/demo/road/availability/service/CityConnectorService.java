package com.demo.road.availability.service;

import com.demo.road.availability.model.CityDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CityConnectorService {

    @Qualifier(value = "cityDetailsCustom")
    @Autowired
    private CityDetails cityDetails;

    public String isCityConnected(String origin, String destination) {
        String cityConnected = "no";
        if (cityDetails.getCityMap().containsKey(origin) && cityDetails.getCityMap().containsKey(destination)) {
            cityConnected = "yes";
        } else if (cityDetails.getCityMap().containsValue(origin) && cityDetails.getCityMap().containsKey(destination)) {
            cityConnected = "yes";
        } else if (cityDetails.getCityMap().containsKey(origin)) {
            String value = cityDetails.getCityMap().get(origin).trim();
            if (value.equalsIgnoreCase(destination.trim())) {
                cityConnected = "yes";
            }
        }
        return cityConnected;
    }
}
