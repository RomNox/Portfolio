package tests;

import com.herokuapp.pages.HorizontalSliderPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HorizontalSliderTest extends TestBase {

    private HorizontalSliderPage sliderPage;

    @BeforeMethod
    public void precondition() {
        sliderPage = new HorizontalSliderPage(app.getDriver()); // Получаем драйвер через ApplicationManager
        sliderPage.navigateTo("https://the-internet.herokuapp.com/horizontal_slider");
    }

    @Test
    public void moveSliderToMaxValueTest() {
        sliderPage.moveSliderToValue(3.0)
                .verifySliderValue(3.0);
    }

    @Test
    public void moveSliderToMiddleValueTest() {
        sliderPage.moveSliderToValue(2)
                .verifySliderValue(2);
    }
}
