package hr.tvz.mc2.constant;


import hr.tvz.mc2.R;

/**
 * Created by mjovanovic on 13.03.14..
 */
public enum WeatherIcon {
    ICON_SUNNY_DAY("01d", R.drawable.m01d, false),
    ICON_SUNNY_NIGHT("01n", R.drawable.m01n, false),

    ICON_PARTLY_SUNNY_DAY("02d", R.drawable.m02d, false),
    ICON_PARTLY_SUNNY_NIGHT("02n", R.drawable.m02n, false),

    ICON_CLOUDY_DAY("03d", R.drawable.m03d, false),
    ICON_CLOUDY_NIGHT("03n", R.drawable.m03n, false),

    ICON_DARK_CLOUDY_DAY("04d", R.drawable.m04d, false),
    ICON_DARK_CLOUDY_NIGHT("04n", R.drawable.m04n, false),

    ICON_HEAVY_RAIN_DAY("09d", R.drawable.m09d, false),
    ICON_HEAVY_RAIN_NIGHT("09n", R.drawable.m09n, false),

    ICON_RAIN_DAY("10d", R.drawable.m10d, false),
    ICON_RAIN_NIGHT("10n", R.drawable.m10n, false),

    ICON_THUNDER_DAY("11d", R.drawable.m11d, false),
    ICON_THUNDER_NIGHT("11n", R.drawable.m11n, false),

    ICON_SNOW_DAY("13d", R.drawable.m13d, false),
    ICON_SNOW_NIGHT("13n", R.drawable.m13n, false),

    ICON_MIST_DAY("50d", R.drawable.m50d, false),
    ICON_MIST_NIGHT("50n", R.drawable.m50n, false),

    //-~-~-~-~-~-~-~-~-~-~-~-~-~//
    // SIDE ICONS
    //-~-~-~-~-~-~-~-~-~-~-~-~-~//

    ICON_SUNNY_SIDE_DAY("01d", R.drawable.s01d, true),
    ICON_SUNNY_SIDE_NIGHT("01n", R.drawable.s01n, true),

    ICON_PARTLY_SIDE_SUNNY_DAY("02d", R.drawable.s02d, true),
    ICON_PARTLY_SIDE_SUNNY_NIGHT("02n", R.drawable.s02n, true),

    ICON_CLOUDY_SIDE_DAY("03d", R.drawable.s03d, true),
    ICON_CLOUDY_SIDE_NIGHT("03n", R.drawable.s03n, true),

    ICON_DARK_CLOUDY_SIDE_DAY("04d", R.drawable.s04d, true),
    ICON_DARK_CLOUDY_SIDE_NIGHT("04n", R.drawable.s04n, true),

    ICON_HEAVY_RAIN_SIDE_DAY("09d", R.drawable.s09d, true),
    ICON_HEAVY_RAIN_SIDE_NIGHT("09n", R.drawable.s09n, true),

    ICON_RAIN_SIDE_DAY("10d", R.drawable.s10d, true),
    ICON_RAIN_SIDE_NIGHT("10n", R.drawable.s10n, true),

    ICON_THUNDER_SIDE_DAY("11d", R.drawable.s11d, true),
    ICON_THUNDER_SIDE_NIGHT("11n", R.drawable.s11n, true),

    ICON_SNOW_SIDE_DAY("13d", R.drawable.s13d, true),
    ICON_SNOW_SIDE_NIGHT("13n", R.drawable.s13n, true),

    ICON_MIST_SIDE_DAY("50d", R.drawable.s50d, true),
    ICON_MIST_SIDE_NIGHT("50n", R.drawable.s50n, true)
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
