package pl.krzysztof;

import org.json.JSONObject;

import java.util.Scanner;

public class Weatherv2 {

    public Location loc;
    public String cityName;
    private String lastUpdate;
    private String conditionText;
    private String alert;

    private double temperature;
    private double pressure;

    public Weatherv2() {
        if (weatherObj != null && alertObj != null){
            this.cityName = DataFromJson.getLocationName(weatherObj);
            this.lastUpdate = DataFromJson.getLastUpdate(weatherObj);
            this.conditionText = DataFromJson.getWeatherConditionText(weatherObj);
            this.alert = DataFromJson.getAlert(alertObj);
            this.temperature = DataFromJson.getTemperature(weatherObj);
            this.pressure = DataFromJson.getPressure(weatherObj);
        }
    }



    Scanner scan = new Scanner(System.in);

    String locationName = scan.nextLine();

    Location location = new Location(locationName);
    String city = location.getLocationName();


    JSONObject weatherObj = DataFromJson.createWeatherJsonObj(city);
    JSONObject alertObj = DataFromJson.createAlertJsonObj(city);


    public String getLastUpdate() {
        return this.lastUpdate;
    }

    public String getConditionText() {
        return this.conditionText;
    }

    public String getAlert() {
        return this.alert ;
    }

    public double getTemperature() {
        return this.temperature ;
    }

    public double getPressure() {
        return this.pressure;
    }

    public String getCityName() {
        return this.cityName;
    }

}


