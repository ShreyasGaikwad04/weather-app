package com.weather.weatherapp;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    public WeatherResponse fetchWeather(String city) {

        String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        JSONObject json = new JSONObject(response);

        WeatherResponse weather = new WeatherResponse();
        weather.setCity(json.getString("name"));
        weather.setTemperature(json.getJSONObject("main").getDouble("temp"));
        weather.setHumidity(json.getJSONObject("main").getInt("humidity"));
        weather.setPressure(json.getJSONObject("main").getInt("pressure"));
        weather.setDescription(
                json.getJSONArray("weather").getJSONObject(0).getString("description")
        );
        weather.setWindSpeed(json.getJSONObject("wind").getDouble("speed"));

        return weather;
    }
}
