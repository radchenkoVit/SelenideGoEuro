package pages;

public class ResultPage extends BasePage{

    public boolean isOpened() {
        return verifyUrl("search2");
    }
}
