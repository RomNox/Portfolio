package com.petscare.listeners;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.List;
import java.util.Random;

public class TestListener implements WebDriverListener {

    Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("The test has a problem");
        logger.info("*********************************************");

        logger.info("Method --> " + method.getName());
        logger.info("*********************************************");

        logger.info("Target exception --> " + e.getTargetException());
        logger.info("*********************************************");

        logger.info("Object target --> " + target.toString());
        logger.info("*********************************************");

        int i = new Random().nextInt(1000) + 1000;
        String link = "screenshots/screen-" + i + ".png";

        WebDriver driver = (ChromeDriver) target;
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File tmp = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp.toPath(), new File(link).toPath());
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);

        logger.info("The locator will find --> " + locator);
        logger.info("*********************************************");
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);

        logger.info("The locator is --> " + locator);
        logger.info("*********************************************");
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);

        logger.info("Before finding elements --> " + locator);
        logger.info("*********************************************");
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);

        logger.info("List size is --> " + result.size());
        logger.info("*********************************************");
    }

}
