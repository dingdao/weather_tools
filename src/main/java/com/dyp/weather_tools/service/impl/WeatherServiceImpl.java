package com.dyp.weather_tools.service.impl;

import com.dyp.weather_tools.config.WeatherConfig;
import com.dyp.weather_tools.result.Result;
import com.dyp.weather_tools.result.ResultCode;
import com.dyp.weather_tools.service.WeatherService;
import com.dyp.weather_tools.util.HttpUtils;
import com.dyp.weather_tools.vo.WeatherVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    WeatherConfig weatherConfig;

    @Override
    public Result<WeatherVo> getWeatherByCity(String city) {

        String city_id = "";
        WeatherVo weatherVo = new WeatherVo();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 设置日期格式

        //todo : get city code. Setup data in mysql ,accoding to city name to get city id. now hardcode.

        if(city.equals("dalian")){
            city_id = "101070201";
        }else if(city.equals("beijing")){
            city_id = "101010100";
        }else if(city.equals("shanghai")){
            city_id = "101020100";
        }else{
            return Result.failure(ResultCode.WEATHER_CITY_ERROR);
        }

        //get info from api
        String weather_api_url = weatherConfig.getWeather_api_url();
        weather_api_url = weather_api_url + city_id + ".html";
        Map<String ,Object> resultMap = HttpUtils.doGet(weather_api_url);

        Map<String ,String> weather_data = (Map<String, String>) resultMap.get("weatherinfo");

        weatherVo.setCity(weather_data.get("city"));
        weatherVo.setUpdateTime(simpleDateFormat.format(new Date()));
        weatherVo.setHumidity(weather_data.get("SD"));
        weatherVo.setTemperature(weather_data.get("temp"));
        weatherVo.setWind(weather_data.get("WD"));

        System.out.println(weatherVo);
        return Result.success(weatherVo);
    }
}
