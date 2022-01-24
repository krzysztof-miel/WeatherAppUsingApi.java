package pl.krzysztof;

public class UrlCreator {
    public static String searchCityUrl(String city) {
        String cityNameToUrl = correctCity(city);
        String urlToSearchMethod = "http://api.weatherapi.com/v1/search.json?key=e31d87cc6994433b9e9195159212112&q=";
        return urlToSearchMethod+cityNameToUrl;
    }

    public static String currentCityUrl(String city) {
        String cityNameToUrl = correctCity(city);
        String firstCurrentUrl = "https://api.weatherapi.com/v1/current.json?key=e31d87cc6994433b9e9195159212112&q=";
        String secondCurrentUrl = "&aqi=yes&lang=pl";
        return firstCurrentUrl + cityNameToUrl + secondCurrentUrl;
    }
    public static String alertUrl(String city){
        String cityNameToUrl = correctCity(city);
        String firstAlertUrl = "http://api.weatherapi.com/v1/forecast.json?key=e31d87cc6994433b9e9195159212112&q=";
        String secondAlertUrl = "&days=1&aqi=yes&alerts=yes";
        return firstAlertUrl + cityNameToUrl + secondAlertUrl;
    }

    private static String correctCity(String name){
        String[] splitCity = name.split(" ");
        name = String.join("-", splitCity); //łaczenie wieloczlonowego smiasta w jednej wyraz
        return name;
    }


}
