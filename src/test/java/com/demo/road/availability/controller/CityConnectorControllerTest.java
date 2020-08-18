package com.demo.road.availability.controller;

import com.demo.road.availability.model.CityDetails;
import com.demo.road.availability.service.CityConnectorService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
public class CityConnectorControllerTest {

    @InjectMocks
    private CityConnectorController cityConnectorController;

    @Mock
    private CityConnectorService cityConnectorService;

    @Mock
    private CityDetails cityDetails;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void cityConnected() throws Exception {

        Map<String, String> map = new HashMap<>();
        File file = new File(getClass().getClassLoader().getResource("City.txt").getFile());
        Stream<String> stream= Files.lines(file.toPath());
        map = stream.map(str -> str.split(","))
                .collect(Collectors.toMap(str -> str[0], str -> str[1]));

        Mockito.when(cityDetails.getCityMap()).thenReturn(map);
        Mockito.when(cityConnectorService.isCityConnected("","")).thenReturn("yes");

        Assert.assertEquals(null,cityConnectorController.isGivenCitiesConnected("Boston","Newark"));
    }

}
