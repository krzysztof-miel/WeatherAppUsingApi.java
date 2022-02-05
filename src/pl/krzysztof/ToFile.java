package pl.krzysztof;

import java.io.FileWriter;
import java.io.IOException;

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
}
