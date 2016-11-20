package pages.resultPage;

import com.codeborne.selenide.Condition;
import pages.BasePage;
import pages.Waiting;

import static com.codeborne.selenide.Selenide.$$;

public class ResultPage extends BasePage {

    private static int oneResult = 1;
    private static String resultBlockLocator = "//div[@data-test='Result']";

    public boolean isOpened() {
        return false; //TODO
    }

    public ResultPage selectMode(TransportMode transportMode){
        $(transportMode.getLocator()).click(); return this;
    }

    public ResultPage shouldBeResults(int quantity){
        TransportMode transportMode = TransportMode.Train;
        return shouldBeResults(transportMode, quantity);
    }

    public ResultPage shouldBeResults(TransportMode transportMode){
        return shouldBeResults(transportMode, oneResult);
    }

    public ResultPage shouldBeResults(){
        return shouldBeResults(TransportMode.Train, oneResult);
    }

    public ResultPage shouldBeResults(TransportMode transportMode, int quantity){
        selectMode(transportMode);
        $(resultBlockLocator).waitUntil(Condition.visible, Waiting.LONG);
        $$(getByFromString(resultBlockLocator)).filter(Condition.visible).shouldHaveSize(quantity);
        return this;
    }

}
