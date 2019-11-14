package com.dyp.weather_tools.controller;

import com.dyp.weather_tools.result.Result;
import com.dyp.weather_tools.service.WeatherService;
import com.dyp.weather_tools.vo.WeatherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    public WeatherService weatherService;
    /**
     * Get weather info from weather api.
     * @return
     */
    @RequestMapping(value="weather/{city}",method= RequestMethod.GET)
    public Result<WeatherVo> weatherInfo(@PathVariable String city) {

        return weatherService.getWeatherByCity(city);
    }
}
