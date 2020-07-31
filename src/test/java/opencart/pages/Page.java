package opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public String rootUrl;

    public Page(WebDriver driver, String rootUrl) {
        this.rootUrl = rootUrl;
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

}