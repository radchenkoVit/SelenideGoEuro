package pages.searchPage;

public enum TripMode {
    OneWayTrip("R"), RoundTrip("O");
    private static String tripLocatorPattern = "//li[.//a[@value='%s']]";

    private String value;

    TripMode(String value){
        this.value = value;
    }

    public String getLocator(){
        return String.format(tripLocatorPattern, value);
    }
}
