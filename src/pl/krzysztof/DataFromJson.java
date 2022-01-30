package pl.krzysztof;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataFromJson {
    public static JSONObject createWeatherJsonObj(String city){
        String output  = GetUrlContent.getContents (UrlCreator.currentCityUrl(city));
        if (output == null){
            System.out.println("błąd w trakcie pobirania danych");
            return null;
        }
        return new JSONObject(output);
    }

    public static JSONObject createAlertJsonObj(String city) {
        String output  = GetUrlContent.getContents(UrlCreator.alertUrl(city));
        if (output == null){
            System.out.println("błąd w trakcie pobirania danych");
            return null;
        }
        return new JSONObject(output);
    }

    public static String getLocationName(JSONObject locationNameJsonObj) {
        return locationNameJsonObj.getJSONObject("location").getString("name");
    }

    public static double getTemperature(JSONObject tempJsonObj){
        return tempJsonObj.getJSONObject("current").getDouble("temp_c");
    }

    public static double getPressure(JSONObject pressureJsonObj){
        return pressureJsonObj.getJSONObject("current").getDouble("pressure_mb");
    }

    public static String getLastUpdate(JSONObject lastUpdateJsonObj){
        return lastUpdateJsonObj.getJSONObject("current").getString("last_updated");
    }

    public static String getWeatherConditionText(JSONObject conditionTextJsonObj){
        return conditionTextJsonObj.getJSONObject("current").getJSONObject("condition").getString("text");
    }

    public static String getAlert(JSONObject alertJsonObj) {
        if (alertJsonObj != null){
            JSONArray arr = alertJsonObj.getJSONObject("alerts").getJSONArray("alert");

            if (arr.isEmpty()){
                return "brak alertu";
            }

            JSONObject alertObj = (JSONObject) arr.get(0);
            return alertObj.getString("desc");
        }else return "brak alertu";
    }
}
