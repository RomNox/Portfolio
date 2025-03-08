package com.petscare.appmanager;

import com.petscare.listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class ApplicationManager {

    String browser;
    public WebDriver driver;

    public ApplicationManager(String browser) {
            this.browser = browser;
        }
    public WebDriver startTest() {

        if (browser.equals("chrome")) {
                driver = new ChromeDriver();
        }else if(browser.equals("firefox")){
                driver = new FirefoxDriver();
        }else if (browser != null &&
                !browser.equals("chrome") &&
                !browser.equals("firefox")){
            throw new IllegalArgumentException("Browser entered is not correct");
        }
        driver = new EventFiringDecorator(new TestListener()).decorate(driver);


        driver.get("https://pets-care-u2srs.ondigitalocean.app/");
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    public void stopTest() {
        driver.quit();
    }
}


