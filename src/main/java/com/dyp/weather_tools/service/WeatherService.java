package com.dyp.weather_tools.service;

import com.dyp.weather_tools.result.Result;
import com.dyp.weather_tools.vo.WeatherVo;

public interface WeatherService {

    public Result<WeatherVo> getWeatherByCity(String city);

}
