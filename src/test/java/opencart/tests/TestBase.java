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
    // Указываем, какие данные хотим получить из сьюта
    @Parameters({"rootUrl", "adminLogin", "adminPassword"})
    // Передаем в параметрах переменные, которым будут присвоены значения. Важно, это отдельные переменные, то что выше, никак с ними не связаны
    public void start(String rootUrl, String adminLogin, String adminPassword) {

        // Слева в выражении переменные из класса, справа из функции. Без этого присвоения данные будут видны только внутри функции
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
        this.rootUrl = rootUrl;

        if (tlApp.get() != null) {
            app = tlApp.get();
            return;
        }

        // Передаем в конструктор корневую ссылку для того, чтобы затем можно было ее передать в конструкторы классов страниц
        app = new Application(this.rootUrl);
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null; }));
    }

}