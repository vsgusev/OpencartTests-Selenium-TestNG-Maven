package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPanelLoginPage extends Page {

    public AdminPanelLoginPage(WebDriver driver, String rootUrl) {
        super(driver, rootUrl);
    }

    public AdminPanelLoginPage open() {
        // Благодаря переменной rootUrl в классе Page мы имеем доступ к этой переменой в любом классе наследнике через this.rootLink
        driver.get(this.rootUrl + "/admin/index.php?route=common/login");
        return this;
    }

    public boolean isOnThisPage() {
        return driver.findElements(By.xpath("//div[@class='panel-body']")).size() > 0;
    }

    public AdminPanelLoginPage enterUsername(String admin) {
        driver.findElement(By.name("username")).sendKeys(admin);
        return this;
    }

    public AdminPanelLoginPage enterPassword(String password) {
        driver.findElement(By.name("password")).sendKeys(password);
        return this;
    }

    public void submitLogin() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("column-left")));
    }

}