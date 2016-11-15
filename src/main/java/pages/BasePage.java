package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public abstract class BasePage {

        protected SelenideElement $(String locator){
            return com.codeborne.selenide.Selenide.$(getByFromString(locator));
        }

        private By getByFromString(String xpathOrCss){
            return !xpathOrCss.startsWith("//")
                    && !xpathOrCss.startsWith(".//")
                    && !xpathOrCss.startsWith("(//")
                    && !xpathOrCss.startsWith("(.//")
                    && !xpathOrCss.startsWith("/*//")
                    && !xpathOrCss.startsWith("(./*")
                    && !xpathOrCss.startsWith("((//")
                    ?By.cssSelector(xpathOrCss):By.xpath(xpathOrCss);
        }

    protected boolean verifyUrl(String url){
        return getWebDriver().getCurrentUrl().contains(url.toLowerCase().trim());
    }

    public abstract boolean isOpened();

}
