package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(tagName = "a")
    private List<WebElement> allLinks;

    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemoveLink;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getAllLinks() {
        return allLinks;
    }

    public boolean isLinkPresent(String linkText) {
        return allLinks.stream().anyMatch(link -> link.getText().equals(linkText));
    }

    public void clickAddRemoveElements() {
        addRemoveLink.click();
    }

    public void clickLink(String linkText) {
        allLinks.stream()
                .filter(link -> link.getText().equals(linkText))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public WebElement getLinkByText(String linkText) {
        return allLinks.stream()
                .filter(link -> link.getText().equals(linkText))
                .findFirst()
                .orElse(null);
    }
}