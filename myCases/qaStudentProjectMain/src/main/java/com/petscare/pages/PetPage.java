package com.petscare.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PetPage extends BasePage{

    public PetPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//button[contains(text(),'My Pets')]")
    WebElement myPetButton;

    public PetPage clickMyPetButton() {
        click(myPetButton);
        return this;

    }

    @FindBy (xpath = "//span[contains(text(),'Add a New Pet')]")
    WebElement myAddNewPet;


    public PetPage clickOnAddNewPet() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAddNewPet)).click();
        return this;
    }

    @FindBy(xpath = "//input[@name='name']")
    WebElement petNameField;

    public PetPage namePet(String name) {

        type(petNameField,name);
        return  this;

    }

    @FindBy(xpath = "//select[@name='type']")
    WebElement selectType;

    public PetPage selectTypeCategory() {
        new Select(selectType).selectByValue("cat");
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveButton;

    public PetPage clickSaveButton() {
        click(saveButton);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Delete Pet')]")
    WebElement deletePetButton;

    public PetPage clickDeleteButton() {
        click(deletePetButton);
        return this;
    }


}
