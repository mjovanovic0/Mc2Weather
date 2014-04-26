package hr.tvz.mc2.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import hr.tvz.mc2.rest.model.ForecastResponse;

/**
 * Created by mjovanovic on 13.03.14..
 */
public final class ForecastUtils {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2014-03-13 09:00:00
    public static final SimpleDateFormat DATE_NAME_FORMAT = new SimpleDateFormat("EEEE");

    public static String getDateName(long timestamp){
        return DATE_NAME_FORMAT.format(new Date((long)timestamp*1000));
    }

    private static int getHourFromString(long timestamp){
        return getHourFromDate(new Date((long)timestamp*1000));
    }

    private static int getHourFromDate(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.HOUR_OF_DAY);
    }

    private static Calendar getForecastStart(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal;
    }

    public static Calendar getCalendarFromString(long timestamp){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date((long)timestamp*1000));
        return cal;
    }

    public static void filterForecasts(List<ForecastResponse.Forecast> forecasts, ForecastResponse forecastResponse) {
        for(ForecastResponse.Forecast f : forecastResponse.getForecasts()){
            if(getHourFromString(f.getDt()) == 12 && getCalendarFromString(f.getDt()).after(getForecastStart()) && forecasts.size() < 5){
                forecasts.add(f);
            }
        }

    }
}
