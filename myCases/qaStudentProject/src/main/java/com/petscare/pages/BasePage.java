package com.petscare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.Duration;

public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static final Logger logger = LoggerFactory.getLogger(BasePage.class);

    // Клик по элементу
    public void click(WebElement element){
        element.click();
    }

    // Ввод текста в поле
    public void type(WebElement element, String text){
        if (text != null){
            click(element);
            element.clear();
            element.sendKeys(text);
        }
    }

    // Проверка наличия текста в элементе
    public boolean shouldHaveText(WebElement element, String text) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    // Проверка исчезновения элемента
    public void shouldBeInvisible(By locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void pause(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
