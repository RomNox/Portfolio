package tests;

import com.herokuapp.pages.HoversPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTest extends TestBase {

    private HoversPage hoversPage;

    @BeforeMethod
    public void setUpPage() {
        hoversPage = new HoversPage(app.getDriver());
        hoversPage.openPage();
    }

    @Test
    public void testHoverOverFirstFigure() {
        hoversPage.hoverOverFigure(1);
        Assert.assertTrue(hoversPage.isCaptionDisplayedForFigure(1), "Caption for the first figure should be displayed");
    }

    @Test
    public void testHoverOverSecondFigure() {
        hoversPage.hoverOverFigure(2);
        Assert.assertTrue(hoversPage.isCaptionDisplayedForFigure(2), "Caption for the second figure should be displayed");
    }

    @Test
    public void testHoverOverThirdFigure() {
        hoversPage.hoverOverFigure(3);
        Assert.assertTrue(hoversPage.isCaptionDisplayedForFigure(3), "Caption for the third figure should be displayed");
    }
}
