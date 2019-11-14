package com.dyp.weather_tools.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource(value="classpath:application.yml")
public class WeatherConfig {

    @Value("${weather.api}")
    private String weather_api_url;
}
