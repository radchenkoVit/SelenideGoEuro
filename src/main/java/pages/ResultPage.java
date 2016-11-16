package pages;

public class ResultPage extends BasePage{

    public boolean isOpened() {
        logger.info("Is opened");
        return verifyUrl("search2");
    }
}
