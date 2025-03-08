package com.herokuapp.pages.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class MyListener implements WebDriverListener {

    private static final Logger logger = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error("An error occurred during method execution: {}", method.getName(), e);

        // Check if the target is a WebDriver instance
        if (target instanceof WebDriver driver) {
            captureScreenshot(driver);
        } else {
            logger.warn("Target is not an instance of WebDriver: {}", target.getClass().getName());
        }
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info("Attempting to locate element using: {}", locator);
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info("Element located successfully: {}", locator);
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        logger.info("Attempting to locate multiple elements using: {}", locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        logger.info("Located {} elements using: {}", result.size(), locator);
    }

    private void captureScreenshot(WebDriver driver) {
        int screenshotId = new Random().nextInt(1000) + 1000;
        String screenshotPath = "screenshots/screen-" + screenshotId + ".png";

        try {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            Files.copy(screenshotFile, new File(screenshotPath));
            logger.info("Screenshot captured: {}", screenshotPath);
        } catch (IOException | ClassCastException ex) {
            logger.error("Failed to capture screenshot", ex);
        }
    }
}
