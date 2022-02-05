package pl.krzysztof;

import org.json.JSONObject;

public class Weather {

    public String cityName;
    private String lastUpdate;
    private String conditionText;
    private String alert;

    private double temperature;
    private double pressure;

    public Weather(JSONObject weatherObj, JSONObject alertObj) {
        if (weatherObj != null && alertObj != null){
            this.cityName = DataFromJson.getLocationName(weatherObj);
            this.lastUpdate = DataFromJson.getLastUpdate(weatherObj);
            this.conditionText = DataFromJson.getWeatherConditionText(weatherObj);
            this.alert = DataFromJson.getAlert(alertObj);
            this.temperature = DataFromJson.getTemperature(weatherObj);
            this.pressure = DataFromJson.getPressure(weatherObj);
        }
    }






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

    @Override
    public String toString() {

        return lastUpdate + "\n" +
                cityName + "\n" +
                "temperatura: " + temperature +"\n" +
                "ciśnienie: " + pressure + "\n" +
                conditionText + "\n" +
                "Alert: " + alert + "\n";

    }
}


