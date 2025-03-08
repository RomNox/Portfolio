package com.petscare.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ServicePage extends BasePage {

    public ServicePage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[contains(text(),'My Services')]")
    WebElement myServicesButton;

    public ServicePage clickOnMyServicesButton() {
        click(myServicesButton);
        return this;
    }



    @FindBy(xpath = "//span[contains(text(),'Add a New Service')]")
    WebElement addNewServiceButton;

    public ServicePage clickOnAddNewServices() {
        click(addNewServiceButton);
        return this;
    }


    @FindBy(xpath = "//input[@placeholder='Dog sitter']")
    WebElement titleField;

    @FindBy(xpath = "//input[@placeholder='15']")
    WebElement priceField;

    @FindBy(xpath = "(//textarea)[1]")
    WebElement descriptionField;

    public ServicePage titlePreisDescription(String title, String price, String description) {

        // Заполняем поле "titleField"
      type(titleField,title);

        // Заполняем поле "priceField"
        type(priceField,price);

        // Заполняем поле "descriptionField"
       type(descriptionField,description);

        return this;

    }


    @FindBy(xpath = "//select[@name='type']")
    WebElement selectCategoryType;



    public ServicePage selectCategory() {
        new Select(selectCategoryType).selectByValue("1");
        return this;

    }

    @FindBy(xpath = "//button[text()='Add Service']")
    WebElement addServiceButton;

    public ServicePage clickAddServiceButton() {
       click(addServiceButton);

       return this;

    }

    @FindBy(xpath = "//button[text()='Delete']")
    WebElement deleteButton;

    public ServicePage clickOnDeleteButton() {
       click(deleteButton);
        return this;
    }

    @FindBy(xpath = "//*[.='No services found.']")
    WebElement noService;

    public ServicePage verifyDeleteServices(String text){
        Assert.assertTrue(shouldHaveText(noService,text));
        return this;
    }
    @FindBy(xpath = "//h3[contains(text(),'Cat sitter')]")
    WebElement catSitter;
    public ServicePage verifyAddedService(String text) {
        Assert.assertTrue(catSitter.getText().contains(text));
        return this;
    }
}


