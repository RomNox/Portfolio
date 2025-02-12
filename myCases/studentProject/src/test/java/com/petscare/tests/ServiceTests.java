package com.petscare.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.petscare.pages.HomePage;
import com.petscare.pages.LoginPage;
import com.petscare.pages.ServicePage;

public class ServiceTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectLogIn();
        new LoginPage(driver).login("dana345@gm.com", "Dana345$");
    }

    @Test
    public void addNewUserServicePositiveTest() {
        new ServicePage(driver)
                .clickOnMyServicesButton()
                .clickOnAddNewServices()
                .titlePreisDescription("Cat sitter","30","Providing reliable pet sitting services.")
                .selectCategory()
                .clickAddServiceButton()
                .verifyAddedService("Cat sitter");

    }
    @Test
    public void deleteServicePositiveTest(){
        new ServicePage(driver)
                .clickOnMyServicesButton()
                .clickOnDeleteButton()
                .verifyDeleteServices("No services found.");



    }
}





