package pl.krzysztof;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CitiesFromFile {
    private static Integer takeCityAmount(){
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Podaj dla ilu miast chcesz poznać pogodę");
            String cityAmount = scanner.nextLine();
            return Integer.parseInt(cityAmount);
        }catch (Exception e){
            System.out.println("Wprowadzono błędną wartość");
            return 0;
        }
    }

    public static void readWeatherForCitiesFromFile(){
        int locAmount = CitiesFromFile.takeCityAmount();
        if (locAmount == 0){
//            System.out.println("Błąd readWeatherForCitiesFromFile");
            return;
        }

        ToFile.writeCitiesToFile(locAmount);

        try (BufferedReader br = new BufferedReader(new FileReader("inputCityName.txt")))
        {
            String cityFromFile;
            while((cityFromFile = br.readLine()) != null) {
                Weather weather = WeatherForLocation.getWeatherForLocation(cityFromFile);
                if (weather != null){
                    System.out.println(weather);
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd w trakcie odczytu z pliku");
        }

    }
}
