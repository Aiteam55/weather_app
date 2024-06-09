package com.aiteam.weatherapp.data.repository

import com.aiteam.weatherapp.data.mappers.toWeatherInfo
import com.aiteam.weatherapp.data.remote.WeatherApi
import com.aiteam.weatherapp.domain.repository.WeatherRepository
import com.aiteam.weatherapp.domain.util.Resource
import com.aiteam.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val api: WeatherApi) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }

}