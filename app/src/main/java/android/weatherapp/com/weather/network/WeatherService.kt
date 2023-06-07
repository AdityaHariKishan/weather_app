package android.weatherapp.com.weather.network

import android.weatherapp.com.weather.model.WeatherObject
import android.weatherapp.com.weather.model.Weathers
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
        const val API_KEY = "71974e85156ea3350d395a5d3b198d18"
    }

    @GET("data/2.5/group")
    suspend fun getWeathersList(
        @Query("id") citiesIds: String,
        @Query("appid") appid: String = API_KEY,
        @Query("units") units: String = "metric"
    ): Response<Weathers>

    @GET("data/2.5/weather")
    suspend fun getWeatherByLatLon(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("appid") appid: String = API_KEY,
        @Query("units") units: String = "metric"
    ): Response<WeatherObject>

    @GET("data/2.5/weather")
    suspend fun getWeatherByCityName(
        @Query("q") citiesIds: String,
        @Query("appid") appid: String = API_KEY,
        @Query("units") units: String = "metric"
    ): Response<WeatherObject>

    @GET("data/2.5/weather")
    suspend fun getWeatherByCityNameCountryCode(
        @Query("q") citiesIds: String,
        @Query("appid") appid: String = API_KEY,
        @Query("units") units: String = "metric"
    ): Response<WeatherObject>
}
