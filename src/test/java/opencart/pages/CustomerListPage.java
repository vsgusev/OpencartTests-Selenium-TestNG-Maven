package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class CustomerListPage extends Page {

    public CustomerListPage(WebDriver driver, String rootUrl) {
        super(driver, rootUrl);
        PageFactory.initElements(driver, this);
    }

    public CustomerListPage open() {
        driver.findElement(By.xpath("//li[@id='menu-customer']")).click();
        driver.findElement(By.xpath("//ul[@id='collapse5']//a[contains(text(),'Customers')]")).click();
        return this;
    }

    @FindBy(xpath = "//table[@class='table table-bordered table-hover']//tbody/tr")
    private List<WebElement> customerRows;

    public Set<String> getCustomerEmails() {
        return customerRows.stream()
                .map(e -> e.findElements(By.tagName("td")).get(2).getText())
                .collect(toSet());
    }

}