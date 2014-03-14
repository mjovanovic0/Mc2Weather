package com.example.dragandrop.adapters;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dragandrop.app.MainActivity;
import com.example.dragandrop.app.R;
import com.example.dragandrop.constant.WeatherIcon;
import com.example.dragandrop.rest.model.ForecastResponse;
import com.example.dragandrop.utils.ForecastUtils;
import com.example.dragandrop.utils.StringUtils;


import java.util.List;

/**
 * Created by mjovanovic on 13.03.14..
 */
public class ForecastAdapter extends ArrayAdapter<ForecastResponse.Forecast> {

    private LayoutInflater inflater;

    public ForecastAdapter (Context context, List<ForecastResponse.Forecast> objects) {
        super(context, 0, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView (int position, View view, ViewGroup parent) {

        if (view == null) {
            view = inflater.inflate(R.layout.side_widget, null);
        }

        ForecastResponse.Forecast forecast = getItem(position);

        TextView txtSideDay = (TextView)view.findViewById(R.id.txtSideDay);
        TextView txtSideTempMin = (TextView)view.findViewById(R.id.txtSideTempMin);
        ImageView imgSide = (ImageView)view.findViewById(R.id.imgSideImage);
        TextView txtSideTempMax = (TextView)view.findViewById(R.id.txtSideTempMax);
        TextView txtSideDescr = (TextView)view.findViewById(R.id.txtSideDescr);

        txtSideDay.setText(ForecastUtils.getDateName(forecast.getDt()));

        txtSideTempMin.setText(StringUtils.build(forecast.getTemperatures().getMin(), MainActivity.DEGREE_CHAR));
        txtSideTempMax.setText(StringUtils.build(forecast.getTemperatures().getMax(), MainActivity.DEGREE_CHAR));

        imgSide.setImageResource(WeatherIcon.getDrawable(forecast.getWeathers()[0].getIcon(), true));
        txtSideDescr.setText(StringUtils.getStringByName(view.getContext(), "cond", forecast.getWeathers()[0].getId()));

        return view;


    }
}
