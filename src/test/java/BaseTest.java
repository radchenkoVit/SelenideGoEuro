import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.resultPage.ResultPage;
import pages.searchPage.Hotel;
import pages.searchPage.SearchPage;

import static pages.resultPage.TransportMode.*;

public class BaseTest {
    private static String fromCity = "Berlin";
    private static String toCity = "Cologne";
    private static int expectedResultQuantity = 10;
    private String url = "http://www.goeuro.com/";


    @BeforeSuite
    public void setUp(){
        FirefoxDriverManager.getInstance().setup();
    }

    @Test
    public void searchTest(){
        SearchPage searchPage = new SearchPage();

        ResultPage resultPage = searchPage.open(url)
                .unsSelectHotel(Hotel.AirBnb)
                .typeFromCity(fromCity).selectCity(fromCity)
                .typeToCity(toCity).selectCity(toCity)
                .search();

        resultPage.shouldBeResults(Flight, expectedResultQuantity);
    }
}
