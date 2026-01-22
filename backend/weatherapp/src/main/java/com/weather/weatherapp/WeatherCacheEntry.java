package com.weather.weatherapp;

public class WeatherCacheEntry {
    private Object data;
    private long expiryTime;

    public WeatherCacheEntry(Object data, long ttlMs) {
        this.data = data;
        this.expiryTime = System.currentTimeMillis() + ttlMs;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > expiryTime;
    }

    public Object getData() {
        return data;
    }
}
