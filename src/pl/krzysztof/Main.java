package pl.krzysztof;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
                case "1": // wyszukiwanie ogody dla konkretnego miasta
                    Weather weather1 = WeatherForLocation.getWeatherForLocation();
                    if (weather1 != null){
                        System.out.println(weather1);
                    }
                    break;
                case "2": // wszykiwanie likalizacji, której nie jestesmy pewni
                    Weather weather2 = PotentialLocation.getWeatherForLocationFromList();
                    if (weather2 != null){
                        System.out.println(weather2);
                    }
                    break;
                case "3": // wyszukiwanie kilku lokalozacji jednocześnie
                    CitiesFromFile.readWeatherForCitiesFromFile();
                    break;
                case "4":
                    System.out.println("koniec");
                    flag = true;
                    break;
                default:
                    System.out.println("taka opcja jest niedostępna");


            }
        }
    }
}
