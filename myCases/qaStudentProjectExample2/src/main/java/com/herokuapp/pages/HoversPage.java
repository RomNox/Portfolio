package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HoversPage extends BasePage {

    private final String PAGE_URL = "https://the-internet.herokuapp.com/hovers";

    @FindBy(css = ".figure")
    private List<WebElement> figures;

    @FindBy(css = ".figcaption")
    private List<WebElement> captions;

    public HoversPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void hoverOverFigure(int index) {
        if (index < 1 || index > figures.size()) {
            throw new IllegalArgumentException("Invalid index for hover element");
        }
        WebElement figure = figures.get(index - 1);
        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();
    }

    public boolean isCaptionDisplayedForFigure(int index) {
        if (index < 1 || index > captions.size()) {
            throw new IllegalArgumentException("Invalid index for caption element");
        }
        return captions.get(index - 1).isDisplayed();
    }
}
