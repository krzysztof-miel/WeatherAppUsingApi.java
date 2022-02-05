package pl.krzysztof;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetUrlContent {
    public static String getContents(String theUrl)
    {
        if (!InternetConnection.isNetAvailable()){
            System.out.println("brak internetu");
            return null;
        }

        StringBuilder content = new StringBuilder();
        // Use try and catch to avoid the exceptions
        try
        {
            URL url = new URL(theUrl); // creating a url object
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection(); // creating a urlconnection object

            int urlCode = urlConnection.getResponseCode();
            if (urlCode !=200){
                System.out.println("GetUrlContent class -> error");
                return null;

            }

            // wrapping the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // reading from the urlconnection using the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }
}
