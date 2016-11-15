import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

public class BaseTest {

    @BeforeSuite
    public void setUp(){
        FirefoxDriverManager.getInstance().setup();
    }

    private String url = "http://www.goeuro.com/";

    @Test
    public void test(){
        SearchPage searchPage = new SearchPage();
        searchPage.open(url)
                .typeFromCity("Berlin").selectCity("Berlin")
                .typeToCity("Cologne").selectCity("Cologne")
                .search();

        ResultPage resultPage = new ResultPage();
        Assert.assertTrue(resultPage.isOpened(), "Result Page is not opened");
    }
}
