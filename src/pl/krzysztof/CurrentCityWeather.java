package pl.krzysztof;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class CurrentCityWeather {
    public void getLocationWeather(String city ) {
        String output  = GetUrlContent.getContents (UrlCreator.currentCityUrl(city));
        if (output == null){
            return;
        }

        JSONObject obj = new JSONObject(output); //tworzenie obiektu na bazie metody korzystajacej z url

        String pageName = obj.getJSONObject("location").getString("name");
        double temp = obj.getJSONObject("current").getDouble("temp_c");
        double pressure = obj.getJSONObject("current").getDouble("pressure_mb");
        String update = obj.getJSONObject("current").getString("last_updated");
        String conditionText = obj.getJSONObject("current").getJSONObject("condition").getString("text");

        System.out.println(pageName);
        System.out.println(update);
        System.out.println(conditionText);
        System.out.println("Temperatura: " + temp); // szukanie i drukowanie nazywamiasta i temperatury w jsonowym formacie
        System.out.println("Ciśnienie: " + pressure);
        System.out.println();

        getAlert(city);
        System.out.println();

        try (FileWriter myWriter = new FileWriter("weatherFile.txt", true))
        {

            myWriter.write(pageName + "\n");
            myWriter.write(update + "\n");
            myWriter.write(conditionText + "\n");
            myWriter.write("Temperatura: " + temp + "\n");
            myWriter.write("Ciśnienie: " + pressure + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    private static void getAlert(String city){

        String output  = GetUrlContent.getContents(UrlCreator.alertUrl(city));

        if (output == null){
            return;
        }

        JSONObject obj = new JSONObject(output);

        System.out.println("Alert: ");
        JSONArray arr = obj.getJSONObject("alerts").getJSONArray("alert");
        if (arr.isEmpty()){
            System.out.println("nie ma alertu dla tej miejscowości");
            return;
        }

        JSONObject alertObj = (JSONObject) arr.get(0);
        System.out.println(alertObj.getString("desc"));

    }
}
