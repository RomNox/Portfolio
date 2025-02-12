package com.petscare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='firstName']")
    WebElement firstNameField;
    @FindBy(xpath = "//input[@id='lastName']")
    WebElement lastNameField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    public RegistrationPage enterUserData(String firstName, String lastName, String email, String password) {
        type(firstNameField, firstName);
        type(lastNameField, lastName);
        type(emailField, email);
        type(passwordField, password);
        return this;
    }

    @FindBy(xpath = "//input[@id='consent']")
    WebElement consent;

    @FindBy(xpath = "//input[@id='policy']")
    WebElement policy;

    public RegistrationPage checkBoxes() {
        if (!consent.isSelected()){
            click(consent);
        }
        if (!policy.isSelected()){
            click(policy);
        }
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'An error occurred during registration. You may have entered an existing email.')]")
    WebElement warningMessage;

    public RegistrationPage verifyMessageOfExistedUser(String text) {
        Assert.assertTrue(warningMessage.getText().contains(text));
        return this;
    }

    @FindBy(xpath = "//div[contains(text(),'Password must be at least 8 characters long, include one uppercase letter, one number, and one special character.')]")
    WebElement invalidPassword;
    public RegistrationPage verifyMessageOfInvalidPassword(String text) {
        Assert.assertTrue(invalidPassword.getText().contains(text));
        return this;
    }

    public boolean verifyMessageOfInvalidEmail() {
        WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
        String validationMessage = emailField.getAttribute("validationMessage");
        String expectedMessage1 = "Адрес электронной почты должен содержать символ \"@\". В адресе \"pereiragmail.com\" отсутствует символ \"@\".";
        String expectedMessage2 = "Недопустимое положение символа \".\" в адресе \".com\".";
        String expectedMessage3 = "Введите часть адреса до символа \"@\". Адрес \"@gmail.com\" неполный.";
        return validationMessage.equals(expectedMessage1) || validationMessage.equals(expectedMessage2) || validationMessage.equals(expectedMessage3);
    }

    public boolean checkBoxValidationTest() {
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='consent']"));
        String validationMessage = checkBox.getAttribute("validationMessage");
        String expectedMessage = "Чтобы продолжить, установите этот флажок.";
        return validationMessage.equals(expectedMessage);

    }

    public boolean isFirstNameErrorDisplayed() {
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        String validationMessage = firstName.getAttribute("validationMessage");
        String expectedMessage = "Заполните это поле.";
        return validationMessage.equals(expectedMessage);
    }

    public boolean isLastNameErrorDisplayed() {
        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        String validationMessage = lastName.getAttribute("validationMessage");
        String expectedMessage = "Заполните это поле.";
        return validationMessage.equals(expectedMessage);
    }

    @FindBy(xpath = "//button[contains(text(),'Create account')]")
    WebElement createAccountButton;

    public Object clickOnCreateAccountButton() {
        click(createAccountButton);
        if (driver.getCurrentUrl().contains("/register")) {
            return this;
        }
        return new LoginPage(driver);
    }
}