package pl.krzysztof;

import org.json.JSONObject;

import java.util.Scanner;

public class WeatherForLocation {
    private static Location crateLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwe miasta");
        String locationName = scanner.nextLine();
        Location location = new Location(locationName);

        if (location.ifLocationExist()) {
            return location;
        } else {
            System.out.println("błądna lokalizacja");
            return null;
        }

    }
    public static Location createLocation(String locName){
        Location location = new Location(locName);

        if (location.ifLocationExist()) {
            return location;
        } else {
            System.out.println("błądna lokalizacja");
            return null;
        }
    }

//    private static JSONObject createWeatherJsonObj(Location loc) {
//        String locNameToJson = loc.getLocationName();
//        return DataFromJson.createWeatherJsonObj(locNameToJson);
//
//
//    }
//
//    private static JSONObject createAlertJsonObj(Location loc) {
//        String locNameToJson = loc.getLocationName();
//        return DataFromJson.createAlertJsonObj(locNameToJson);
//
//    }

    public static Weather getWeatherForLocation() {
        Location loc = WeatherForLocation.crateLocation();
        if (loc != null) {
            String locName = loc.getLocationName();
            Weather weather = new Weather(DataFromJson.createWeatherJsonObj(locName), DataFromJson.createAlertJsonObj(locName));
            ToFile.writeWeather(weather);
            return weather;
        }
        return null;
    }

    public static Weather getWeatherForLocation(String locName){
        Location loc = WeatherForLocation.createLocation(locName);
        if (loc != null) {
            String locationName = loc.getLocationName();
            Weather weather = new Weather(DataFromJson.createWeatherJsonObj(locName), DataFromJson.createAlertJsonObj(locName));
            ToFile.writeWeather(weather);
            return weather;
        }
        return null;
    }

}
