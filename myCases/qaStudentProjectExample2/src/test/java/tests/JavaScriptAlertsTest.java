package tests;

import com.herokuapp.pages.AlertHelper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends TestBase {

    @Test
    public void testJsAlert() {
        app.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        app.getDriver().findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        AlertHelper alertHelper = new AlertHelper(app.getDriver());
        String alertText = alertHelper.acceptAlert();

        Assert.assertEquals(alertText, "I am a JS Alert", "Текст JS Alert не совпадает");
    }

    @Test
    public void testJsConfirm() {
        app.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        app.getDriver().findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        AlertHelper alertHelper = new AlertHelper(app.getDriver());
        String alertText = alertHelper.dismissAlert();

        Assert.assertEquals(alertText, "I am a JS Confirm", "Текст JS Confirm не совпадает");
    }

    @Test
    public void testJsPrompt() {
        app.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        app.getDriver().findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        AlertHelper alertHelper = new AlertHelper(app.getDriver());
        alertHelper.sendTextToAlertAndAccept("Test Prompt");

        String resultText = app.getDriver().findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("Test Prompt"), "Результат не содержит введённый текст");
    }
}
