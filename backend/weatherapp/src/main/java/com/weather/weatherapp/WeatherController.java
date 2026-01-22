package com.weather.weatherapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class WeatherController {
    private final WeatherService service;
    private final long TTL = 300000;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) {

        String key = city.toLowerCase();

        if (WeatherCache.contains(key)) {
            WeatherCacheEntry entry = WeatherCache.get(key);
            if (!entry.isExpired()) {
                return (WeatherResponse) entry.getData();
            }
            WeatherCache.remove(key);
        }

        WeatherResponse weather = service.fetchWeather(city);
        WeatherCache.put(key, new WeatherCacheEntry(weather, TTL));
        return weather;
    }
}
