import React from "react";

function WeatherCard({ weather }) {
  if (!weather) return null;

  return (
    <div className="weather-card">
      <h2>{weather.city}</h2>
      <p className="desc">{weather.description}</p>

      <div className="info">
        <p> Temperature: {weather.temperature} °C</p>
        <p> Humidity: {weather.humidity}%</p>
        <p> Wind: {weather.windSpeed} m/s</p>
        <p> Pressure: {weather.pressure} hPa</p>
      </div>
    </div>
  );
}

export default WeatherCard;
