package hr.tvz.mc2.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import hr.tvz.mc2.R;
import hr.tvz.mc2.constant.WeatherIcon;
import hr.tvz.mc2.rest.model.ForecastResponse;
import hr.tvz.mc2.rest.model.WeatherResponse;
import hr.tvz.mc2.utils.StringUtils;

/**
 * Created by ivankocijan on 14.03.2014..
 */
public class MainScreenFragment extends Fragment {

    public static final String DEGREE_CHAR = "" + (char) 0x00B0;

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
    @InjectView(R.id.imgToday)
    ImageView imgToday;

    public static String TAG = "MainScreenFragment";

    private static MainScreenFragment mainScreenFragment;

    public static synchronized MainScreenFragment getInstance () {

        if (mainScreenFragment == null) {

            mainScreenFragment = new MainScreenFragment();

        }

        return mainScreenFragment;

    }

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main_screen, container, false);


        ButterKnife.inject(this, rootView);


        return rootView;
    }


    @Override
    public void onDestroy () {
        super.onDestroy();

        ButterKnife.reset(this);
    }

    public void initScreen (ForecastResponse.Forecast todayForecast, ForecastResponse forecastResponse, WeatherResponse weatherResponse) {

        txtDescr.setText(StringUtils.getStringByName(getActivity(), "cond", todayForecast.getWeathers()[0].getId()));
        txtCityName.setText(forecastResponse.getCity().getName());
        txtTempNight.setText(StringUtils.build("Night ", todayForecast.getTemperatures().getNight(), DEGREE_CHAR));

        txtTemp.setText(StringUtils.build(weatherResponse.getMain().getTemp(), DEGREE_CHAR));
        txtTempMin.setText(StringUtils.build("Min ", todayForecast.getTemperatures().getMin(), DEGREE_CHAR));
        txtTempMax.setText(StringUtils.build("Max ", todayForecast.getTemperatures().getMax(), DEGREE_CHAR));

        imgToday.setImageResource(WeatherIcon.getDrawable(weatherResponse.getWeather()[0].getIcon(), false));

    }

}
