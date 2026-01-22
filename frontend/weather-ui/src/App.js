import React, { useState } from "react";
import SearchBar from "./components/SearchBar";
import WeatherCard from "./components/WeatherCard";
import "./App.css";

function App() {
  const [weather, setWeather] = useState(null);

  const fetchWeather = async (city) => {
    if (!city) return;

    const res = await fetch(
      `http://localhost:8080/api/weather?city=${city}`
    );
    const data = await res.json();
    setWeather(data);
  };

  return (
    <div className="app">
      <h1 className="title">🌤 Weather App</h1>
      <SearchBar onSearch={fetchWeather} />
      <WeatherCard weather={weather} />
    </div>
  );
}

export default App;
