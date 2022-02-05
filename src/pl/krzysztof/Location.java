package pl.krzysztof;

public class Location {
    private final String locationName;

    public Location(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationName() {
        return locationName;
    }
    public boolean ifLocationExist() {
        String locToCheck = getLocationName();
        String urlToCheck = UrlCreator.currentCityUrl(locToCheck);
        return GetUrlContent.getContents(urlToCheck) != null;
    }
}
