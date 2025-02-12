package com.petscare.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.petscare.pages.HomePage;
import com.petscare.pages.LoginPage;
import com.petscare.pages.ServicesCategoriesPage;

public class ServicesCategoriesTests extends TestBase {

    // Авторизация перед каждым тестом
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectLogIn();
        new LoginPage(driver).login("admin@admin.com", "admin");
    }

    // Тест на добавление категории
    @Test
    public void testAddCategoryPositiveTest() {
        new ServicesCategoriesPage(driver)
                .goToServicesCategories()
                .addCategory("TestCategory")
                .verifyCategoryExists("TestCategory");
    }

    // Тест на удаление категории (предполагается, что категория уже существует)
    @Test
    public void testDeleteCategoryPositiveTest() {
        new ServicesCategoriesPage(driver)
                .goToServicesCategories()
                .deleteCategory("TestCategory")
                .verifyCategoryDeleted("TestCategory");
    }
}
