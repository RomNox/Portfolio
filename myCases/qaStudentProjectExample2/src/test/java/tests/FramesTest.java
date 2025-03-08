package tests;

import com.herokuapp.pages.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FramesTest extends TestBase {

    private FrameHelper frameHelper;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        frameHelper = new FrameHelper(app.getDriver());
    }

    @Test
    public void testIFrame() {
        app.getDriver().get("https://the-internet.herokuapp.com/frames");
        WebDriverWait wait = new WebDriverWait(app.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("iFrame"))).click();
        frameHelper.switchToFrame("mce_0_ifr");

        WebElement editor = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
        Assert.assertTrue(editor.isDisplayed(), "Редактор в iframe не найден");

        frameHelper.switchToDefaultContent();
    }

    @Test
    public void testNestedFrames() {
        app.getDriver().get("https://the-internet.herokuapp.com/frames");
        WebDriverWait wait = new WebDriverWait(app.getDriver(), Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Nested Frames"))).click();

        frameHelper.switchToFrame("frame-top");
        frameHelper.switchToFrame("frame-left");

        String leftText = app.getDriver().findElement(By.tagName("body")).getText();
        Assert.assertTrue(leftText.contains("LEFT"), "Текст в левом фрейме не совпадает");

        frameHelper.switchToParentFrame();
        frameHelper.switchToFrame("frame-middle");

        String middleText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content"))).getText();
        Assert.assertTrue(middleText.contains("MIDDLE"), "Текст в центральном фрейме не совпадает");

        frameHelper.switchToParentFrame();
        frameHelper.switchToFrame("frame-right");

        String rightText = app.getDriver().findElement(By.tagName("body")).getText();
        Assert.assertTrue(rightText.contains("RIGHT"), "Текст в правом фрейме не совпадает");

        frameHelper.switchToDefaultContent();
    }
}
