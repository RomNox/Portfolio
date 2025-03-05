/**
 * Data Transfer Object (DTO) для UserD.
 * Используется для передачи данных пользователя между слоями приложения.
 * Позволяет собирать данные из пользовательского ввода и создавать объект UserD.
 */

package org.gpoup492project2.dto;

import org.gpoup492project2.entity.User;

public class UserDto {

    // Поля DTO, соответствующие полям класса User
    private String name;              // Имя пользователя
    private String surname;           // Фамилия пользователя
    private String login;             // Логин пользователя
    private Object passwordHash;      // Хэш пароля пользователя

    // Конструктор с параметрами
    public UserDto(String name, String surname, String login, Object passwordHash) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.passwordHash = passwordHash;
    }

    // Преобразование DTO в объект User
    public User toUser() {
        return new User(0,
                this.name,
                this.surname,
                this.login,
                this.passwordHash
        );
    }

    // Геттеры и сеттеры для всех полей

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Object getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(Object passwordHash) {
        this.passwordHash = passwordHash;
    }
}
