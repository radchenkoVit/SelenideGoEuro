package pages;


public class SearchPage extends BasePage {
    private static String fromCityLocator = ".//input[@id='from_filter']";
    private static String toCityLocator = ".//input[@id='to_filter']";
    private static String searchButton = ".//input[contains(@id, 'submit-btn')]";
    private static String dropDownCityCommonLocator = ".//ul/li/a[@id][contains(text(), '%s')]";

    public SearchPage open(String url){
        return com.codeborne.selenide.Selenide.open(url, this.getClass());
    }

    public SearchPage typeFromCity(final String city){
        $(fromCityLocator).setValue(city); return this;
    }

    public SearchPage selectCity(String city){
        String dropDownCityLocator = String.format(dropDownCityCommonLocator, city);
        $(dropDownCityLocator).click(); return this;
    }

    public SearchPage typeToCity(final String city){
        $(toCityLocator).setValue(city); return this;
    }

    public void search(){
        $(searchButton).click();
    }

    @Override
    public boolean isOpened() {
        return verifyUrl("goeuro");
    }
}
