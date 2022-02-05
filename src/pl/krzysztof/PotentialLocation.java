package pl.krzysztof;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PotentialLocation {
    private static JSONArray getLocationJsonArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj lokalizację, której niejesteś pewien");
        String locName = scanner.nextLine();
        Location location = WeatherForLocation.createLocation(locName);
        if (location != null) {
            String name = location.getLocationName();
            JSONArray array = new JSONArray(DataFromJson.crateSearchArrayJsonObj(name));
            if (array.isEmpty()){
                return null;
            }else return array;
        }
        return null;
    }

    private static String getCityFromList() {
        JSONArray citiesArray = PotentialLocation.getLocationJsonArray();
        Scanner scan = new Scanner(System.in);
        if (citiesArray !=null) {
            int i = 1;
            for (Object city : citiesArray) {
                JSONObject cityFromArray = (JSONObject) city;
                System.out.println(i + ". " + cityFromArray.getString("name"));
                i++;
            }
            System.out.print("wybierz miasto do sprawdzenia -> ");
            try {
                int chosenCity = scan.nextInt();
                if (chosenCity < 1 || chosenCity > (i)) {
                    System.out.println("liczba z poza zakresu");
                    return null;
                }
                JSONObject getJsonObjectFromList = (JSONObject) citiesArray.get(chosenCity - 1);
                return getJsonObjectFromList.getString("name");

            } catch (InputMismatchException e) {
                System.out.println("Niewłaściwa propozycja");

            }
        }
        return null;
    }

    // dodać wyszukiwanie wskazanej lokalizacji
    // dodać metodę do Main menu

    public static Weather getWeatherForLocationFromList(){
        String locFromList = PotentialLocation.getCityFromList();
        if (locFromList != null){
            return WeatherForLocation.getWeatherForLocation(locFromList);
        }
        return null;
    }

}


