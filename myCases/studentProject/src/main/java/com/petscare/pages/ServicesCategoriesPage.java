package com.petscare.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServicesCategoriesPage extends BasePage {

    public ServicesCategoriesPage(WebDriver driver) {
        super(driver);
    }

    // Локаторы
    @FindBy(xpath = "//button[contains(text(),'Admin Section')]")
    private WebElement adminSectionButton;

    @FindBy(xpath = "//a[@href='#/admin/services_categories']")
    private WebElement servicesCategoriesLink;

    @FindBy(css = "input[placeholder='New category title']")
    private WebElement newCategoryInput;

    @FindBy(xpath = "//button[contains(text(),'Add Category')]")
    private WebElement addCategoryButton;

    // Переход в раздел Services Categories
    public ServicesCategoriesPage goToServicesCategories() {
        click(adminSectionButton);
        click(servicesCategoriesLink);
        return this;
    }

    // Добавление новой категории
    public ServicesCategoriesPage addCategory(String categoryName) {
        type(newCategoryInput, categoryName);
        click(addCategoryButton);
        return this;
    }

    // Проверка, что категория добавлена
    public ServicesCategoriesPage verifyCategoryExists(String categoryName) {
        WebElement categoryElement = driver.findElement(By.xpath("//td[text()='" + categoryName + "']"));
        shouldHaveText(categoryElement, categoryName);
        return this;
    }

    // Удаление категории
    public ServicesCategoriesPage deleteCategory(String categoryName) {
        WebElement deleteButton = driver.findElement(By.xpath("//tbody/tr[5]/td[2]/button[2]"));
        click(deleteButton);
        driver.switchTo().alert().accept(); // Подтверждаем удаление через алерт
        return this;
    }

    // Проверка, что категория удалена
    public ServicesCategoriesPage verifyCategoryDeleted(String categoryName) {
        shouldBeInvisible(By.xpath("//td[text()='" + categoryName + "']"), 10);
        return this;
    }
}
