package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MultipleWindowsPage extends BasePage {

    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickClickHereLink() {
        clickHereLink.click();
    }

    public void switchToNewWindow() {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
    }
}
