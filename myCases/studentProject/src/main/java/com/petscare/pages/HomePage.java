package com.petscare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[href='#/register']")
    WebElement registration;

    public RegistrationPage selectSignUp() {
        click(registration);
        return new RegistrationPage(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Welcome to Pet Service')]")
    WebElement homeComponent;

    public HomePage verifyHomeComponentPresent(String text) {
        Assert.assertTrue(homeComponent.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//a[contains(text(),'Log in')]")
    WebElement loginButton;
    public LoginPage selectLogIn() {
        click(loginButton);
        return new LoginPage(driver);
    }

}