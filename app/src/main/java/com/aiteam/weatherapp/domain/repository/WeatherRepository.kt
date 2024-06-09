package com.aiteam.weatherapp.domain.repository

import com.aiteam.weatherapp.domain.util.Resource
import com.aiteam.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}