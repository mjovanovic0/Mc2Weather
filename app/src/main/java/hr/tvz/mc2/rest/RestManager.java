package hr.tvz.mc2.rest;

import android.util.Log;

import hr.tvz.mc2.rest.model.ForecastResponse;
import hr.tvz.mc2.rest.model.WeatherResponse;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by mjovanovic on 13.03.14..
 */
public class RestManager {

    public static final String SERVICE_URL = "http://api.openweathermap.org/data/2.5";

    public interface IRestService {

        @GET("/weather")
        public void getWeather(@Query("q") String cityName, @Query("units") String units, Callback<WeatherResponse> cb);

        @GET("/forecast/daily")
        public void getForecast(@Query("q") String cityName, @Query("cnt") int forecasts, @Query("units") String units, Callback<ForecastResponse> cb);

    }

    private static IRestService serviceHolder;

    public static IRestService getService(){
        if(serviceHolder == null){
            synchronized (RestManager.class){
                RestAdapter.Log logger = new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.d("Mc2Retrofit", message);
                    }
                };

                serviceHolder = new RestAdapter.Builder().setLog(logger)
                        .setLogLevel(RestAdapter.LogLevel.FULL)
                        .setEndpoint(SERVICE_URL)
                        .build()
                        .create(IRestService.class);
            }
        }
        return  serviceHolder;
    };

    private static final String UNITS_METRICS = "metric";

    public static void getWeather(String cityName, Callback<WeatherResponse> callback){
        getService().getWeather(cityName, UNITS_METRICS, callback);
    }

    public static void getForecast(String cityName, Callback<ForecastResponse> callback){
        getService().getForecast(cityName, 7, UNITS_METRICS, callback);
    }

}
