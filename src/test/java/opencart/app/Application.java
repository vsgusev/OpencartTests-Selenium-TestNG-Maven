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
    public String rootUrl;

    // При создании объекта app у нас будет корневая ссылка в this.rootUrl
    public Application(String rootUrl) {
        this.rootUrl = rootUrl;

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Помимо объекта драйвера, передаем корневую ссылку в конструкторы
        registrationPage = new RegistrationPage(driver, rootUrl);
        adminPanelLoginPage = new AdminPanelLoginPage(driver, rootUrl);
        customerListPage = new CustomerListPage(driver, rootUrl);
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

    public Set<String> getCustomerEmails(String login, String password) {
        if (adminPanelLoginPage.open().isOnThisPage()) {
            adminPanelLoginPage.enterUsername(login).enterPassword(password).submitLogin();
        }

        return customerListPage.open().getCustomerEmails();
    }

}