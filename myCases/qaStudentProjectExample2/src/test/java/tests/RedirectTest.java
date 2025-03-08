package tests;

import com.herokuapp.pages.BasePage;
import com.herokuapp.pages.RedirectPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RedirectTest extends TestBase {

    @BeforeMethod
    public void navigateToRedirectPage() {
        BasePage basePage = new BasePage(app.getDriver());
        basePage.clickLinkByText("Redirect Link");  // Переходим по ссылке с главной страницы
    }

    @Test
    public void testRedirectStatusCodes() {
        RedirectPage redirectPage = new RedirectPage(app.getDriver());
        redirectPage.clickRedirectLink();
        redirectPage.verifyStatusCodes();
    }
}
