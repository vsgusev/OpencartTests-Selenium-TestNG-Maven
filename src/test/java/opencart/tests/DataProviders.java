package opencart.tests;

import opencart.model.Customer;
import org.testng.annotations.DataProvider;


public class DataProviders {

    @DataProvider(name = "validCustomers")
    public static Object[][] validCustomers() {
        return new Object[][] {
                { Customer.newEntity()
                        .withFirstname("John")
                        .withLastname("Smith")
                        .withPhone("+0123456789")
                        .withEmail("john" + System.currentTimeMillis() + "@smith.me")
                        .withPassword("qwerty").build() },
                        /* ... */
                };
    }

}