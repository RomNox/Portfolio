package com.petscare.tests;

import com.petscare.appmanager.ApplicationManager;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;


public class TestBase   {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected ApplicationManager app = new ApplicationManager(System.getProperty("browser", "chrome"));
    WebDriver driver;

    @BeforeMethod
    public void setUp(Method method){
        driver = app.startTest();
        logger.info("Start test: " + method.getName());
    }

    @AfterMethod(enabled = true)
    public void tearDown(ITestResult result) {
        if (result.isSuccess()){
            logger.info("Test result: PASSED " + result.getMethod().getMethodName());
        } else {
            logger.error("Test result: FAILED " + result.getMethod().getMethodName());
        }
        logger.info("***************************************************************");
        app.stopTest();
    }



}



