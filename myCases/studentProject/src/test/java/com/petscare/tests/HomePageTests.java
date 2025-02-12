package com.petscare.tests;

import org.testng.annotations.Test;
import com.petscare.pages.HomePage;

public class HomePageTests extends TestBase{

    @Test
    public void isHomeComponentPresentTest(){

       new HomePage(driver).verifyHomeComponentPresent("Welcome to Pet Service");

    }

}