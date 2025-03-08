package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedirectPage extends BasePage {

    @FindBy(linkText = "here")
    private WebElement redirectLink;

    public RedirectPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickRedirectLink() {
        redirectLink.click();
    }

    public void verifyStatusCodes() {
        WebElement statusCodeMessage = driver.findElement(By.cssSelector("p"));
        String statusCodeText = statusCodeMessage.getText();

        if (statusCodeText.contains("200")) {
            System.out.println("Status code is 200: OK");
        } else if (statusCodeText.contains("301")) {
            System.out.println("Status code is 301: Moved Permanently");
        } else if (statusCodeText.contains("404")) {
            System.out.println("Status code is 404: Not Found");
        } else if (statusCodeText.contains("500")) {
            System.out.println("Status code is 500: Internal Server Error");
        } else {
            System.out.println("Unknown status code");
        }
    }
}
