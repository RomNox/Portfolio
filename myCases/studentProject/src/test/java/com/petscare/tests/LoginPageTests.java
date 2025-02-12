package com.petscare.tests;

import com.petscare.data.DataProviders;
import com.petscare.models.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.petscare.pages.HomePage;
import com.petscare.pages.LoginPage;

public class LoginPageTests extends TestBase {

    // Переход на страницу логина перед каждым тестом
    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectLogIn();
    }

    // Успешный вход с валидными данными
    @Test(dataProvider = "validLoginData", dataProviderClass = DataProviders.class)
    public void testLoginWithValidDataPositiveTest(UserData user) {
        new LoginPage(driver)
                .login(user.getEmail(), user.getPassword())
                .verifySuccessLogin("/user");
    }


    @Test(dataProvider = "invalidLoginDataWithoutEmptyFields", dataProviderClass = DataProviders.class)
    public void testLoginWithInvalidDataNegativeTest(UserData user) {
        new LoginPage(driver)
                .login(user.getEmail(), user.getPassword())
                .verifyErrorMessage("Произошла ошибка. Попробуйте позже.");
    }

    // Проверка валидации пустых полей
    @Test(dataProvider = "emptyFieldsData", dataProviderClass = DataProviders.class)
    public void testEmptyFieldsValidationNegativeTest(String email, String password) {
        new LoginPage(driver)
                .login(email, password)
                .verifyEmptyFieldsValidation(email, password); // Теперь передаем параметры
    }
}