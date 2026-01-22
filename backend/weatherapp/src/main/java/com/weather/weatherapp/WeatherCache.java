package com.weather.weatherapp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WeatherCache {

    private static final Map<String, WeatherCacheEntry> CACHE =
            new ConcurrentHashMap<>();

    public static void put(String key, WeatherCacheEntry value) {
        CACHE.put(key, value);
    }

    public static WeatherCacheEntry get(String key) {
        return CACHE.get(key);
    }

    public static boolean contains(String key) {
        return CACHE.containsKey(key);
    }

    public static void remove(String key) {
        CACHE.remove(key);
    }
}
