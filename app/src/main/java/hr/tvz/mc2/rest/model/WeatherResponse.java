package hr.tvz.mc2.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mjovanovic on 13.03.14..
 */
public class WeatherResponse {

    @SerializedName("coord")
    private Coordinate coordinate;
    @SerializedName("sys")
    private Systematics systematics;
    @SerializedName("weather")
    private Weather[] weather;
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private MainInformation main;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("dt")
    private long dt;
    @SerializedName("id")
    private long id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private int cod;

    public int getCod() {
        return cod;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public long getDt() {
        return dt;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public MainInformation getMain() {
        return main;
    }

    public String getBase() {
        return base;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public Systematics getSystematics() {
        return systematics;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public class Clouds{
        @SerializedName("all")
        private int all;
    }

    public class Wind {
        @SerializedName("speed")
        private float speed;
        @SerializedName("deg")
        private float degree;

        public float getDegree() {
            return degree;
        }

        public float getSpeed() {
            return speed;
        }
    }

    public class MainInformation{
        @SerializedName("temp")
        private float temp;
        @SerializedName("pressure")
        private int pressure;
        @SerializedName("humidity")
        private int humidity;
        @SerializedName("temp_min")
        private float temp_min;
        @SerializedName("temp_max")
        private float temp_max;

        public int getTemp_max() {
            return (int)temp_max;
        }

        public int getTemp_min() {
            return (int)temp_min;
        }

        public int getHumidity() {
            return humidity;
        }

        public int getPressure() {
            return pressure;
        }

        public int getTemp() {
            return (int)temp;
        }
    }

    public class Weather{
        @SerializedName("id")
        private int id;
        @SerializedName("main")
        private String main;
        @SerializedName("description")
        private String description;
        @SerializedName("icon")
        private String icon;

        public String getIcon() {
            return icon;
        }

        public String getDescription() {
            return description;
        }

        public String getMain() {
            return main;
        }

        public int getId() {
            return id;
        }
    }

    public class Systematics{
        @SerializedName("message")
        private float message;
        @SerializedName("country")
        private String country;
        @SerializedName("sunrise")
        private long sunrise;
        @SerializedName("sunset")
        private long sunset;

        public long getSunset() {
            return sunset;
        }

        public long getSunrise() {
            return sunrise;
        }

        public String getCountry() {
            return country;
        }

        public float getMessage() {
            return message;
        }
    }

    public class Coordinate{
        @SerializedName("lon")
        private float lon;
        @SerializedName("lat")
        private float lat;

        public float getLat() {
            return lat;
        }

        public float getLon() {
            return lon;
        }
    }

}
