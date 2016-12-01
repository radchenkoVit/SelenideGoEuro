package pages.searchPage;

import com.codeborne.selenide.Condition;
import pages.BasePage;
import pages.resultPage.ResultPage;

public class SearchPage extends BasePage {
    private static String fromCityLocator = ".//input[@id='from_filter']";
    private static String toCityLocator = ".//input[@id='to_filter']";
    private static String searchButton = ".//input[contains(@id, 'submit-btn')]";
    private static String dropDownCityCommonLocator = ".//ul/li/a[@id][contains(text(), '%s')]";
    private static String hotelCheckBoxPattern = "//div[@data-partner='%s']//span[not(contains(@class, 'disabled'))]";

    public SearchPage open(String url){
        return com.codeborne.selenide.Selenide.open(url, this.getClass());
    }

    public SearchPage typeFromCity(final String city){
        logger.info(String.format("Type city: %s", city));
        $(fromCityLocator).setValue(city); return this;
    }

    public SearchPage selectCity(String city){
        logger.info(String.format("Select city: %s", city));
        String dropDownCityLocator = String.format(dropDownCityCommonLocator, city);
        $(dropDownCityLocator).click(); return this;
    }

    public SearchPage typeToCity(final String city){
        logger.info(String.format("Type city: %s", city));
        $(toCityLocator).setValue(city); return this;
    }

    public ResultPage search(){
        logger.info("Click search button");
        $(searchButton).click();
        return new ResultPage();
    }

    public SearchPage selectTripMode(TripMode tripMode){
        logger.info(String.format("Select TripMode: %s", tripMode));
        $(tripMode.getLocator()).click(); return this;
    }

    public SearchPage selectHotel(Hotel hotel){
        if (!isHotelSelected(hotel)) {
            logger.info(String.format("Select hotel: %s", hotel));
            clickHotelCheckBox(hotel);
        }
        return this;
    }

    public SearchPage unsSelectHotel(Hotel hotel){
        if (isHotelSelected(hotel)) {
            logger.info(String.format("UnSelect hotel: %s", hotel));
            clickHotelCheckBox(hotel);
        }
        return this;
    }

    private SearchPage clickHotelCheckBox(Hotel hotel){
        String hotelLocator = String.format(hotelCheckBoxPattern, hotel);
        $(hotelLocator).shouldBe(Condition.visible).click(); return this;
    }

    public boolean isHotelSelected(Hotel hotel){
        String hotelLocator = String.format(hotelCheckBoxPattern, hotel);
        if ($(hotelLocator).getAttribute("class").contains("checked"))
            return true;

        return false;
    }

    @Override
    public boolean isOpened() {
        return verifyUrl("goeuro");
    }
}
