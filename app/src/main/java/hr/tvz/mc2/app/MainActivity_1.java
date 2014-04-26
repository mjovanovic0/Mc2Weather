package hr.tvz.mc2.app;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import hr.tvz.mc2.R;
import hr.tvz.mc2.adapters.ForecastAdapter;
import hr.tvz.mc2.constant.WeatherIcon;
import hr.tvz.mc2.rest.RestManager;
import hr.tvz.mc2.rest.model.ForecastResponse;
import hr.tvz.mc2.rest.model.WeatherResponse;
import hr.tvz.mc2.utils.ForecastUtils;
import hr.tvz.mc2.utils.StringUtils;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity_1 extends ActionBarActivity {

    public static final String DEGREE_CHAR = "" + (char) 0x00B0;
    private static final String CITY_NAME = "Zagreb,hr";
    private static final String CITY_NAME_SHORT = "Zagreb";

    @InjectView(R.id.txtCityName)
    TextView txtCityName;
    @InjectView(R.id.txtTemp)
    TextView txtTemp;
    @InjectView(R.id.txtTempMin)
    TextView txtTempMin;
    @InjectView(R.id.txtTempMax)
    TextView txtTempMax;
    @InjectView(R.id.txtTempNight)
    TextView txtTempNight;
    @InjectView(R.id.txtDate)
    TextView txtDate;
    @InjectView(R.id.txtDescr)
    TextView txtDescr;
    @InjectView(R.id.listView)
    ListView listView;
    @InjectView(R.id.imgToday)
    ImageView imgToday;
    @InjectView(R.id.imgSettings)
    ImageView imgSettings;

    private ProgressDialog pd;
    private WeatherResponse weatherResponse;
    private ForecastResponse forecastResponse;

    private List<ForecastResponse.Forecast> forecasts;
    private ForecastAdapter listAdapter;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
        ButterKnife.inject(this);

        txtDate.setText(new SimpleDateFormat("dd.MM.yyyy.").format(new Date()));

        pd = new ProgressDialog(this);
        pd.setMessage("Loading");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();

        RestManager.getWeather(CITY_NAME, cityWeatherCallback);
        RestManager.getForecast(CITY_NAME_SHORT, cityForecastCallback);

        forecasts = new ArrayList<ForecastResponse.Forecast>();
        listAdapter = new ForecastAdapter(this, forecasts);
        listView.setAdapter(listAdapter);

        imgSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                startActivityForResult(new Intent(android.provider.Settings.ACTION_SETTINGS), 0);
            }
        });
    }

    private Callback<WeatherResponse> cityWeatherCallback = new Callback<WeatherResponse>() {
        @Override
        public void success (WeatherResponse weatherResponse, Response response) {
            setWeatherResponse(weatherResponse);
            populateScreen();
        }

        @Override
        public void failure (RetrofitError error) {
            pd.hide();
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
            pd.hide();
            Log.e("Mc2Weather", error.getMessage());
        }
    };


    private synchronized void populateScreen () {
        if (weatherResponse == null || forecastResponse == null) {
            return;
        }

        ForecastResponse.Forecast todayForecast = forecastResponse.getForecasts()[0];

        txtDescr.setText(StringUtils.getStringByName(getApplicationContext(), "cond", todayForecast.getWeathers()[0].getId()));
        txtCityName.setText(forecastResponse.getCity().getName());
        txtTempNight.setText(StringUtils.build("Night ", todayForecast.getTemperatures().getNight(), DEGREE_CHAR));

        txtTemp.setText(StringUtils.build(weatherResponse.getMain().getTemp(), DEGREE_CHAR));
        txtTempMin.setText(StringUtils.build("Min ", todayForecast.getTemperatures().getMin(), DEGREE_CHAR));
        txtTempMax.setText(StringUtils.build("Max ", todayForecast.getTemperatures().getMax(), DEGREE_CHAR));

        imgToday.setImageResource(WeatherIcon.getDrawable(weatherResponse.getWeather()[0].getIcon(), false));

        ForecastUtils.filterForecasts(forecasts, forecastResponse);
        listAdapter.notifyDataSetChanged();

        pd.hide();
    }

    public void setWeatherResponse (WeatherResponse weatherResponse) {
        this.weatherResponse = weatherResponse;
    }

    public void setForecastResponse (ForecastResponse forecastResponse) {
        this.forecastResponse = forecastResponse;
    }
}
