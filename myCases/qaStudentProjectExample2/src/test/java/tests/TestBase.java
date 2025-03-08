package tests;

import com.herokuapp.pages.config.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod
    public void tearDown() {
        app.stop();
    }
}