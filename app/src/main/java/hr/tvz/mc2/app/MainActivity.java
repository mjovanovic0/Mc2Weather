package hr.tvz.mc2.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.mc2.R;
import hr.tvz.mc2.fragments.MainScreenFragment;
import hr.tvz.mc2.fragments.NavigationDrawerFragment;
import hr.tvz.mc2.helpers.TransactionHelper;
import hr.tvz.mc2.rest.RestManager;
import hr.tvz.mc2.rest.model.ForecastResponse;
import hr.tvz.mc2.rest.model.WeatherResponse;
import hr.tvz.mc2.utils.ForecastUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private static final String CITY_NAME = "Zagreb,hr";
    private static final String CITY_NAME_SHORT = "Zagreb";

    private WeatherResponse weatherResponse;
    private ForecastResponse forecastResponse;

    private List<ForecastResponse.Forecast> forecasts;

    private NavigationDrawerFragment mNavigationDrawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);

        forecasts = new ArrayList<ForecastResponse.Forecast>();

        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout), forecasts);

        TransactionHelper.switchContentNoAnimation(MainScreenFragment.getInstance(), getFragmentManager(), MainScreenFragment.TAG, R.id.container);

        RestManager.getWeather(CITY_NAME, cityWeatherCallback);
        RestManager.getForecast(CITY_NAME_SHORT, cityForecastCallback);


    }

    private Callback<WeatherResponse> cityWeatherCallback = new Callback<WeatherResponse>() {
        @Override
        public void success (WeatherResponse weatherResponse, Response response) {
            setWeatherResponse(weatherResponse);
            populateScreen();
        }

        @Override
        public void failure (RetrofitError error) {

            Log.e("Mc2Weather", error.getMessage());
        }
    };

    private Callback<ForecastResponse> cityForecastCallback = new Callback<ForecastResponse>() {
        @Override
        public void success (ForecastResponse forecastResponse, Response response) {
            setForecastResponse(forecastResponse);
            populateScreen();
        }

        @Override
        public void failure (RetrofitError error) {

            Log.d("Mc2Weather", "error", error);
        }
    };

    private synchronized void populateScreen () {
        if (weatherResponse == null || forecastResponse == null) {
            return;
        }

        ForecastResponse.Forecast todayForecast = forecastResponse.getForecasts()[0];

        MainScreenFragment.getInstance().initScreen(todayForecast, forecastResponse, weatherResponse);

        ForecastUtils.filterForecasts(forecasts, forecastResponse);

        mNavigationDrawerFragment.notifyAdapter();

    }

    public void setWeatherResponse (WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    public void setForecastResponse (ForecastResponse forecastResponse) {
        this.forecastResponse = forecastResponse;
    }

    @Override
    public void onNavigationDrawerItemSelected (int position) {

    }
}
