package hr.tvz.mc2.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mjovanovic on 13.03.14..
 */
public class ForecastResponse {
    @SerializedName("cod")
    private String cod;
    @SerializedName("message")
    private float message;
    @SerializedName("city")
    private City city;
    @SerializedName("cnt")
    private int cnt;
    @SerializedName("list")
    private Forecast[] forecasts;

    public Forecast[] getForecasts() {
        return forecasts;
    }

    public int getCnt() {
        return cnt;
    }

    public City getCity() {
        return city;
    }

    public float getMessage() {
        return message;
    }

    public String getCod() {
        return cod;
    }

    public class Forecast{
        @SerializedName("dt")
        private long dt;
        @SerializedName("temp")
        private Temperatures temperatures;
        @SerializedName("pressure")
        private float pressure;
        @SerializedName("humidity")
        private int humidity;
        @SerializedName("weather")
        private WeatherResponse.Weather[] weathers;
        @SerializedName("speed")
        private float speed;
        @SerializedName("deg")
        private int deg;
        @SerializedName("clouds")
        private int clouds;

        public int getClouds() {
            return clouds;
        }

        public int getDeg() {
            return deg;
        }

        public float getSpeed() {
            return speed;
        }

        public int getHumidity() {
            return humidity;
        }

        public float getPressure() {
            return pressure;
        }

        public Temperatures getTemperatures() {
            return temperatures;
        }

        public long getDt() {
            return dt;
        }

        public WeatherResponse.Weather[] getWeathers() {
            return weathers;
        }
    }

    public class Temperatures{
        @SerializedName("day")
        private float day;
        @SerializedName("min")
        private float min;
        @SerializedName("max")
        private float max;
        @SerializedName("night")
        private float night;
        @SerializedName("eve")
        private float eve;
        @SerializedName("morn")
        private float morn;

        public int getMorn() {
            return (int)morn;
        }

        public int getEve() {
            return (int)eve;
        }

        public int getNight() {
            return (int)night;
        }

        public int getMax() {
            return (int)max;
        }

        public int getMin() {
            return (int)min;
        }

        public int getDay() {
            return (int)day;
        }
    }

    public class MainInformation{
        @SerializedName("temp")
        private float temp;
        @SerializedName("temp_min")
        private float temp_min;
        @SerializedName("temp_max")
        private float temp_max;
        @SerializedName("pressure")
        private float pressure;
        @SerializedName("sea_level")
        private float seaLevel;
        @SerializedName("grnd_level")
        private float grndLevel;
        @SerializedName("humidity")
        private int humidity;
        @SerializedName("temp_kf")
        private float tempKf;

        public float getTempKf() {
            return tempKf;
        }

        public int getHumidity() {
            return humidity;
        }

        public float getGrndLevel() {
            return grndLevel;
        }

        public float getSeaLevel() {
            return seaLevel;
        }

        public float getPressure() {
            return pressure;
        }

        public int getTemp_max() {
            return (int)temp_max;
        }

        public int getTemp_min() {
            return (int)temp_min;
        }

        public int getTemp() {
            return (int)temp;
        }
    }

    public class City{
        @SerializedName("id")
        private String id;
        @SerializedName("name")
        private String name;
        @SerializedName("coord")
        private WeatherResponse.Coordinate coordinate;
        @SerializedName("country")
        private String country;
        @SerializedName("population")
        private int population;

        public int getPopulation() {
            return population;
        }

        public String getCountry() {
            return country;
        }

        public WeatherResponse.Coordinate getCoordinate() {
            return coordinate;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }
    }
}
