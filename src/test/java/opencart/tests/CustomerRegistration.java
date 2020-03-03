package opencart.tests;

import opencart.model.Customer;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class CustomerRegistration extends TestBase {

    @Test(dataProvider = "validCustomers", dataProviderClass = DataProviders.class)
    public void registerCustomer(Customer customer) {

        Set<String> oldEmails = app.getCustomerEmails();

        app.registerNewCustomer(customer);

        Set<String> newEmails = app.getCustomerEmails();

        assertTrue(newEmails.containsAll(oldEmails));
        assertTrue(newEmails.size() == oldEmails.size() + 1);
    }

}