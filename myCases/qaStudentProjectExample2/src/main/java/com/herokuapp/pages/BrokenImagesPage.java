package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BrokenImagesPage extends BasePage {

    private By imagesLocator = By.tagName("img");

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    public void checkBrokenImages() {
        List<WebElement> images = driver.findElements(imagesLocator);
        for (WebElement img : images) {
            if (img.getAttribute("naturalWidth").equals("0")) {
                System.out.println("Broken image found: " + img.getAttribute("src"));
            } else {
                System.out.println("Image is okay: " + img.getAttribute("src"));
            }
        }
    }
}
