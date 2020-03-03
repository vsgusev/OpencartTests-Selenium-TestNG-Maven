package opencart.app;

import opencart.model.Customer;
import opencart.pages.AdminPanelLoginPage;
import opencart.pages.CustomerListPage;
import opencart.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Application {

    private WebDriver driver;

    private RegistrationPage registrationPage;
    private AdminPanelLoginPage adminPanelLoginPage;
    private CustomerListPage customerListPage;

    public Application() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        registrationPage = new RegistrationPage(driver);
        adminPanelLoginPage = new AdminPanelLoginPage(driver);
        customerListPage = new CustomerListPage(driver);
    }

    public void quit() {
        driver.quit();
    }

    public void registerNewCustomer(Customer customer) {
        registrationPage.open();
        registrationPage.firstnameInput.sendKeys(customer.getFirstname());
        registrationPage.lastnameInput.sendKeys(customer.getLastname());
        registrationPage.emailInput.sendKeys(customer.getEmail());
        registrationPage.telephoneInput.sendKeys(customer.getTelephone());
        registrationPage.passwordInput.sendKeys(customer.getPassword());
        registrationPage.confirmedPasswordInput.sendKeys(customer.getPassword());
        registrationPage.agreePrivacyPolicyCheckBox.click();
        registrationPage.continueButton.click();
    }

    public Set<String> getCustomerEmails() {
        if (adminPanelLoginPage.open().isOnThisPage()) {
            adminPanelLoginPage.enterUsername("admin").enterPassword("password").submitLogin();
        }

        return customerListPage.open().getCustomerEmails();
    }

}