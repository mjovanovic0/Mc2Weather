package hr.tvz.mc2.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hr.tvz.mc2.R;
import hr.tvz.mc2.app.MainActivity_1;
import hr.tvz.mc2.constant.WeatherIcon;
import hr.tvz.mc2.rest.model.ForecastResponse;
import hr.tvz.mc2.utils.ForecastUtils;
import hr.tvz.mc2.utils.StringUtils;

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

        TextView txtSideDay = (TextView) view.findViewById(R.id.txtSideDay);
        TextView txtSideTempMin = (TextView) view.findViewById(R.id.txtSideTempMin);
        ImageView imgSide = (ImageView) view.findViewById(R.id.imgSideImage);
        TextView txtSideTempMax = (TextView) view.findViewById(R.id.txtSideTempMax);
        TextView txtSideDescr = (TextView) view.findViewById(R.id.txtSideDescr);

        txtSideDay.setText(ForecastUtils.getDateName(forecast.getDt()));

        txtSideTempMin.setText(StringUtils.build(forecast.getTemperatures().getMin(), MainActivity_1.DEGREE_CHAR));
        txtSideTempMax.setText(StringUtils.build(forecast.getTemperatures().getMax(), MainActivity_1.DEGREE_CHAR));

        imgSide.setImageResource(WeatherIcon.getDrawable(forecast.getWeathers()[0].getIcon(), true));
        txtSideDescr.setText(StringUtils.getStringByName(view.getContext(), "cond", forecast.getWeathers()[0].getId()));

        return view;


    }
}
