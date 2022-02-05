package pl.krzysztof;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ToFile {
    public static void writeWeather(Weather weather){
        String fullWeather = weather.toString();
        try (FileWriter myWriter = new FileWriter("weatherFile.txt", true))
        {
            myWriter.write(fullWeather);
            System.out.println("Zapisano poparwnie do pliku \n");
        } catch (IOException e) {
            System.out.println("błąd w trakci zapisywania\n");
        }
    }

    public static void writeCitiesToFile(int cityAmount){
        Scanner scan = new Scanner(System.in);
        System.out.println("wprowadz " + cityAmount + " miast");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inputCityName.txt")))
        {
            for (int i=0; i<cityAmount; i++){
                String userCityName = scan.nextLine();
                bw.write(userCityName + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
