package tests;

import com.herokuapp.pages.BasePage;
import com.herokuapp.pages.BrokenImagesPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenImagesTest extends TestBase {

    @BeforeMethod
    public void navigateToBrokenImages() {
        BasePage basePage = new BasePage(app.getDriver());
        basePage.clickLinkByText("Broken Images");
    }

    @Test
    public void testBrokenImages() {
        BrokenImagesPage brokenImagesPage = new BrokenImagesPage(app.getDriver());
        brokenImagesPage.checkBrokenImages();
    }
}
