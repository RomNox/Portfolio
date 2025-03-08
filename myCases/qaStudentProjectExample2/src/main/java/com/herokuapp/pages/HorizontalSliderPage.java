package com.herokuapp.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HorizontalSliderPage extends BasePage {

    public HorizontalSliderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[type='range']")
    private WebElement slider;

    @FindBy(id = "range")
    private WebElement rangeValue;

    public HorizontalSliderPage moveSliderToValue(double targetValue) {
        double currentValue = Double.parseDouble(slider.getAttribute("value"));
        Actions actions = new Actions(driver);
        slider.click();

        while (currentValue != targetValue) {
            if (currentValue < targetValue) {
                actions.sendKeys(slider, Keys.ARROW_RIGHT).perform();
            } else if (currentValue > targetValue) {
                actions.sendKeys(slider, Keys.ARROW_LEFT).perform();
            }
            currentValue = Double.parseDouble(slider.getAttribute("value"));
        }
        return this;
    }

    public HorizontalSliderPage verifySliderValue(double expectedValue) {
        double actualValue = Double.parseDouble(rangeValue.getText());
        Assert.assertEquals(actualValue, expectedValue, "Значение слайдера не совпадает с ожидаемым");
        return this;
    }
}
