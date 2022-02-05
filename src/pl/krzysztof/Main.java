package pl.krzysztof;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SearchCities cities = new SearchCities();
        ReadCityFromFile cityFromFile = new ReadCityFromFile();

        Scanner userInput = new Scanner(System.in);

        try (FileWriter myWriter = new FileWriter("weatherFile.txt"))
        {
         myWriter.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }


        boolean flag = false;
        while (!flag){
            System.out.println("/////  DOSTĘPNE OPCJE  ///// \n" +
                    "1 Wyszukaj pogodę dla konretnego miasta \n" +
                    "2 Zoabcz propozycje jeśli nie jesteś pewny nazy lokalizacji \n" +
                    "3 Sprawdź pogodędla wielu miast \n" +
                    "4 wyjście ");

            String chosenOption = userInput.nextLine();

            switch (chosenOption.trim()){
                case "1":
                    Weather weather1 = WeatherForLocation.getWeatherForLocation();
                    if (weather1 != null){
                        System.out.println(weather1.toString());
                    }
//                    System.out.print("podaj miasto -> ");
//                    String currentCity = userInput.nextLine();
//                    weather.getLocationWeather(currentCity);
                    break;
                case "2":
                    Weather weather2 = PotentialLocation.getWeatherForLocationFromList();
                    if (weather2 != null){
                        System.out.println(weather2.toString());
                    }
                    break;

//                    System.out.print("podaj lokalizację ktorej nie jesteś pewien -> ");
//                    String searchLocation = userInput.nextLine();
//                    cities.getCityName(searchLocation);

                case "3":
                    System.out.println("Wyszukaj więcej miast za jednym razem \nIle miast chciałbyś sprawdzić?");
                    String cityAmount = userInput.nextLine();
                    cityFromFile.writeToFile(cityAmount);
                    break;
                case "4":
                    System.out.println("żegnaj przyjacielu");
                    flag = true;
                    break;
                default:
                    System.out.println("taka opcja jest niedostępna");


            }
        }
    }
}
