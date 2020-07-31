package opencart.tests;

import opencart.model.Customer;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CustomerRegistration extends TestBase {

    @Test(dataProvider = "validCustomers", dataProviderClass = DataProviders.class)
    public void registerCustomer(Customer customer) {

        Set<String> oldEmails = app.getCustomerEmails(adminLogin, adminPassword);

        app.registerNewCustomer(customer);

        Set<String> newEmails = app.getCustomerEmails(adminLogin, adminPassword);

        assertTrue(newEmails.containsAll(oldEmails));
        assertEquals(newEmails.size(), oldEmails.size() + 1);
    }

}