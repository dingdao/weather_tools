package com.dyp.weather_tools.service;

import com.dyp.weather_tools.result.Result;
import com.dyp.weather_tools.service.impl.WeatherServiceImpl;
import com.dyp.weather_tools.vo.WeatherVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
public class WeatherServiceTest {

    @Autowired
    WeatherService weatherService;

    @Test
    public void getWeatherByCity(){
        Result<WeatherVo> weatherVo = weatherService.getWeatherByCity("dalian");
        System.out.println(weatherVo.toString());
    }
}
