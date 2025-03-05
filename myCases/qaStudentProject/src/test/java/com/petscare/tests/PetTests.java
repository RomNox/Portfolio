package com.petscare.tests;

import com.petscare.pages.HomePage;
import com.petscare.pages.LoginPage;
import com.petscare.pages.PetPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PetTests extends TestBase {

    // Авторизация
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectLogIn();
        new LoginPage(driver).login("kseniia987@gm.com", "Kseniia987@");
    }

    // Тест на добавление питомца
    @Test
    public void testAddNewPet() {
        new PetPage(driver)
                .clickMyPetButton()
                .clickOnAddNewPet()
                .namePet("Mars")
                .selectTypeCategory()
                .clickSaveButton();

    }

    //Тест на удаление питомца
    @Test
    public void deletePetTest() {
        new PetPage(driver)
                .clickMyPetButton()
                .clickDeleteButton();


    }

}
