package com.herokuapp.pages.config;

import com.herokuapp.pages.utils.MyListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import java.time.Duration;

public class ApplicationManager {
    private final String browser;
    private WebDriver driver;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void init() {
        WebDriver baseDriver;

        switch (browser.toLowerCase()) {
            case "chrome" -> baseDriver = new ChromeDriver();
            case "firefox" -> baseDriver = new FirefoxDriver();
            default -> throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver = new EventFiringDecorator<>(new MyListener()).decorate(baseDriver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/");
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
        }
    }
}
