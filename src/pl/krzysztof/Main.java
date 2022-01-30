package pl.krzysztof;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CurrentCityWeather weather = new CurrentCityWeather();
        SearchCities cities = new SearchCities();
        ReadCityFromFile cityFromFile = new ReadCityFromFile();

        Scanner userInput = new Scanner(System.in);

//        Location location = new Location("gdansk");
//        String gdansk = location.getLocationName();
//
//        System.out.println(gdansk);

        System.out.println("podaj miejscowość do sprawdzenia pogody");
        Location loc = new Location(userInput.nextLine());

        if (loc.ifLocationExist()){
            Weatherv2 weatherTest = new Weatherv2();
            System.out.println(weatherTest.getLastUpdate());
            System.out.println(weatherTest.getCityName());
            System.out.println(weatherTest.getTemperature());
            System.out.println(weatherTest.getPressure());
            System.out.println(weatherTest.getConditionText());
            System.out.println(weatherTest.getAlert());
        } else {
            System.out.println("błedna lokalizacja");
        }




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
                    System.out.print("podaj miasto -> ");
                    String currentCity = userInput.nextLine();
                    weather.getLocationWeather(currentCity);
                    break;
                case "2":
                    System.out.print("podaj lokalizację ktorej nie jesteś pewien -> ");
                    String searchLocation = userInput.nextLine();
                    cities.getCityName(searchLocation);
                    break;
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
