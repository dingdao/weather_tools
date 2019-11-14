package com.dyp.weather_tools.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class WeatherVo implements Serializable {

    private String city;
    private String updateTime ;
    private String humidity;//湿度
    private String temperature;
    private String wind;
}
