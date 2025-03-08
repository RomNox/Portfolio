package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;

    @FindBy(css = ".added-manually")
    private List<WebElement> deleteButtons;

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Инициализация всех элементов
    }

    public void clickAddElementButton() {
        addElementButton.click();
    }

    public void clickDeleteButton(int index) {
        if (index >= 0 && index < deleteButtons.size()) {
            deleteButtons.get(index).click();
        }
    }

    public int getDeleteButtonCount() {
        return deleteButtons.size();
    }
}
