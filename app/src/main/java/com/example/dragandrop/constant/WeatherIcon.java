package com.example.dragandrop.constant;


import com.example.dragandrop.app.R;

/**
 * Created by mjovanovic on 13.03.14..
 */
public enum WeatherIcon {
    ICON_SUNNY_DAY("01d", R.drawable.sunce, false),
    ICON_SUNNY_NIGHT("01n", R.drawable.sunce, false),

    ICON_PARTLY_SUNNY_DAY("02d", R.drawable.djel_sunce, false),
    ICON_PARTLY_SUNNY_NIGHT("02n", R.drawable.djel_sunce, false),

    ICON_CLOUDY_DAY("03d", R.drawable.oblak, false),
    ICON_CLOUDY_NIGHT("03n", R.drawable.oblak, false),

    ICON_DARK_CLOUDY_DAY("04d", R.drawable.oblak, false),
    ICON_DARK_CLOUDY_NIGHT("04n", R.drawable.oblak, false),

    ICON_HEAVY_RAIN_DAY("09d", R.drawable.kisa, false),
    ICON_HEAVY_RAIN_NIGHT("09n", R.drawable.kisa, false),

    ICON_RAIN_DAY("10d", R.drawable.kisa_sunce, false),
    ICON_RAIN_NIGHT("10n", R.drawable.kisa_sunce, false),

    ICON_THUNDER_DAY("11d", R.drawable.thunder, false),
    ICON_THUNDER_NIGHT("11n", R.drawable.thunder, false),

    ICON_SNOW_DAY("13d", R.drawable.snijeg, false),
    ICON_SNOW_NIGHT("13n", R.drawable.snijeg, false),

    ICON_MIST_DAY("50d", R.drawable.magla, false),
    ICON_MIST_NIGHT("50n", R.drawable.magla, false),

    //-~-~-~-~-~-~-~-~-~-~-~-~-~//
    // SIDE ICONS
    //-~-~-~-~-~-~-~-~-~-~-~-~-~//

    ICON_SUNNY_SIDE_DAY("01d", R.drawable.sunce_gray, true),
    ICON_SUNNY_SIDE_NIGHT("01n", R.drawable.sunce_gray, true),

    ICON_PARTLY_SIDE_SUNNY_DAY("02d", R.drawable.djel_sunce_gray, true),
    ICON_PARTLY_SIDE_SUNNY_NIGHT("02n", R.drawable.djel_sunce_gray, true),

    ICON_CLOUDY_SIDE_DAY("03d", R.drawable.oblak_gray, true),
    ICON_CLOUDY_SIDE_NIGHT("03n", R.drawable.oblak_gray, true),

    ICON_DARK_CLOUDY_SIDE_DAY("04d", R.drawable.oblak_gray, true),
    ICON_DARK_CLOUDY_SIDE_NIGHT("04n", R.drawable.oblak_gray, true),

    ICON_HEAVY_RAIN_SIDE_DAY("09d", R.drawable.kisa_gray, true),
    ICON_HEAVY_RAIN_SIDE_NIGHT("09n", R.drawable.kisa_gray, true),

    ICON_RAIN_SIDE_DAY("10d", R.drawable.kisa_sunce_gray, true),
    ICON_RAIN_SIDE_NIGHT("10n", R.drawable.kisa_sunce_gray, true),

    ICON_THUNDER_SIDE_DAY("11d", R.drawable.thunder_gray, true),
    ICON_THUNDER_SIDE_NIGHT("11n", R.drawable.thunder_gray, true),

    ICON_SNOW_SIDE_DAY("13d", R.drawable.snijeg_gray, true),
    ICON_SNOW_SIDE_NIGHT("13n", R.drawable.snijeg_gray, true),

    ICON_MIST_SIDE_DAY("50d", R.drawable.magla_gray, true),
    ICON_MIST_SIDE_NIGHT("50n", R.drawable.magla_gray, true)
    ;

    private String code;
    private int drawableCode;
    private boolean sideIcon;

    WeatherIcon(String code, int drawableCode, boolean sideIcon){
        this.code = code;
        this.drawableCode = drawableCode;
        this.sideIcon = sideIcon;
    }

    public static int getDrawable(String code, boolean sideIcon){
        for(WeatherIcon icon : values()){
            if(icon.sideIcon == sideIcon && icon.code.equals(code)){
                return icon.drawableCode;
            }
        }
        return 0;
    }
}
