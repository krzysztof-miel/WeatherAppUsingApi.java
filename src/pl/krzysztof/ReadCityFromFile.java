package pl.krzysztof;

import java.io.*;
import java.util.Scanner;

public class ReadCityFromFile {

    public void writeToFile(String amount){
        Scanner scan = new Scanner(System.in);
        CurrentCityWeather cityWeather = new CurrentCityWeather();

        int cityAmount;

        try {
            cityAmount = Integer.parseInt(amount);
            System.out.println("Wprowadz " + cityAmount + " miasta:");
        }catch (NumberFormatException e) {
            System.out.println("Błąd w takcie wprowadzenia ilości miast");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inputCityName.txt")))
        {
            for (int i=0; i<cityAmount; i++){
                String userCityName = scan.nextLine();
                bw.write(userCityName + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("inputCityName.txt")))
        {
            String cityFromFile;
            while((cityFromFile = br.readLine()) != null) {
                System.out.println(cityFromFile);
                cityWeather.getLocationWeather(cityFromFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
