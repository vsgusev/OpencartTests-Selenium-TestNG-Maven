package opencart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends Page {

    public RegistrationPage(WebDriver driver, String rootUrl) {
        super(driver, rootUrl);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get(this.rootUrl + "/index.php?route=account/register");
    }

    @FindBy(name="firstname")
    public WebElement firstnameInput;

    @FindBy(name="lastname")
    public WebElement lastnameInput;

    @FindBy(name="email")
    public WebElement emailInput;

    @FindBy(name="telephone")
    public WebElement telephoneInput;

    @FindBy(name="password")
    public WebElement passwordInput;

    @FindBy(name="confirm")
    public WebElement confirmedPasswordInput;

    @FindBy(name="agree")
    public WebElement agreePrivacyPolicyCheckBox;

    @FindBy(xpath="//input[@class='btn btn-primary']")
    public WebElement continueButton;

}