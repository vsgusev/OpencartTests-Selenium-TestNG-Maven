package opencart.tests;

import opencart.app.Application;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;
    public String rootUrl;
    protected String adminLogin, adminPassword;

    @BeforeClass
    @Parameters({"rootUrl", "adminLogin", "adminPassword"})
    public void start(String rootUrl, String adminLogin, String adminPassword) {
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
        this.rootUrl = rootUrl;
        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        app = new Application(this.rootUrl);
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }

}