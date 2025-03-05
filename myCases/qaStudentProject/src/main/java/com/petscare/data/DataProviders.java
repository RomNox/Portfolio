package com.petscare.data;

import com.petscare.models.UserData;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
                {new UserData("admin@admin.com", "admin", "admin")},  // Администратор
                {new UserData("Romaykin@admin.com", "0682620798Ro@", "user")}  // Обычный пользователь
        };
    }

    @DataProvider(name = "invalidLoginDataWithoutEmptyFields")
    public Object[][] invalidLoginDataWithoutEmptyFields() {
        return new Object[][]{
                {new UserData("invalid_email@example.com", "wrongpassword", "user")}, // Неверный email и пароль
                {new UserData("admin@admin.com", "wrongpassword", "admin")},         // Неверный пароль для администратора
                {new UserData("user@user.com", "wrongpassword", "user")}             // Неверный пароль для пользователя
        };
    }

    @DataProvider(name = "emptyFieldsData")
    public Object[][] emptyFieldsData() {
        return new Object[][]{
                {"", ""},               // Оба поля пустые
                {"validemail@example.com", ""}, // Только пароль пустой
                {"", "validpassword"}   // Только email пустой
        };
    }

    @DataProvider
    public Iterator<Object[]> userRegistrationWithCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csvFiles/newUserRegistration.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> existedUserRegistration() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csvFiles/existedUserRegistration.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userRegistrationWithInvalidEmail() throws IOException {
        CSVUpdater.updateCSVFile();
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csvFiles/invalidEmail.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userRegistrationWithoutDomainName() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csvFiles/emailWithoutDomainName.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userRegistrationWithInvalidPassword() throws IOException {
        CSVUpdater.updateCSVFile();
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csvFiles/invalidPassword.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userRegistrationWithoutFirstName() throws IOException {
        CSVUpdater.updateCSVFile();
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csvFiles/registrationWithoutFirstname.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userRegistrationWithoutLastName() throws IOException {
        CSVUpdater.updateCSVFile();
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/csvFiles/registrationWithoutLastname.csv")));

        String line = reader.readLine();

        while (line != null){

            list.add(line.split(","));

            line = reader.readLine();
        }

        return list.iterator();
    }

}
