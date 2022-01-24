package pl.krzysztof;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchCities {

    public void getCityName(String city) {
        Scanner scan = new Scanner(System.in);

        String searchOutput = GetUrlContent.getContents(UrlCreator.searchCityUrl(city));
        // strorzenie linku z klasy url creator i wrzucenie go do get url content

        if (searchOutput == null){
            return;
        }

        JSONArray arr = new JSONArray(searchOutput);

        if (arr.isEmpty()) {
            System.out.println("lista propozycji jest pusta");
            return;
        }

        int i = 1;
        for (Object obj : arr) {
            JSONObject name = (JSONObject) obj;
            System.out.println(i + ". " + name.getString("name"));
            i++;
        }


        System.out.print("wybierz miasto do sprawdzenia -> ");
        try{
            int chosenCity = scan.nextInt();
            if (chosenCity < 1 || chosenCity > (i)) {
                System.out.println("liczba z poza zakresu");
                return;
            }
            JSONObject getJsonObject = (JSONObject) arr.get(chosenCity-1);
            String cityNameFromJson = getJsonObject.getString("name");
            CurrentCityWeather currentCityWeather = new CurrentCityWeather();
            currentCityWeather.getLocationWeather(cityNameFromJson);


        }catch (InputMismatchException e){
            System.out.println("Niewłaściwa propozycja");
        }


    }
}
