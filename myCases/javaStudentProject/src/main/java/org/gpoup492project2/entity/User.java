/**
 Автор Vladimir Romaikin
 Сohort49-2

 Класс, представляющий пользователя системы.

 Этот класс хранит информацию о пользователе, такую как идентификатор, имя, фамилия, логин и хеш пароля.
 Он предоставляет методы для проверки пароля и переопределяет метод {@code toString()} для удобного представления пользователя в виде строки.

 Основные поля:
 - id: Уникальный идентификатор пользователя.
 - name: Имя пользователя.
 - surname: Фамилия пользователя.
 - login: Логин пользователя для аутентификации.
 - passwordHash: Хеш пароля пользователя.

 Основные методы:
 - encodePassword(String rawPassword): Хеширует предоставленный пароль с использованием BCrypt.
 - checkPassword(String password): Проверяет, соответствует ли предоставленный пароль сохраненному хешу.
 - toString(): Возвращает строковое представление объекта User без отображения хеша пароля для безопасности.

 Конструктор класса и геттеры/сеттеры обеспечивают доступ к полям класса.
 */

package org.gpoup492project2.entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {

    // Переменные (Поля)
    private int id;  // Идентификатор пользователя
    private String name;  // Имя пользователя
    private String surname;  // Фамилия пользователя
    private String login;  // Логин пользователя для аутентификации
    private Object passwordHash; // Храним хеш пароля

    // Конструктор
    public User(int id, String name, String surname, String login, Object passwordHash) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.passwordHash = passwordHash;
    }
    // Конструктор без ID
    public User(String name,String surname, String login, Object passwordHash) {
        this.name = name;
        this.passwordHash = passwordHash;
        this.login = login;
        this.surname = surname;
    }

    public User(String username, Object passwordHash) {
        this.name = name;
        this.passwordHash = passwordHash;
    }

    // Геттеры для всех полей, кроме пароля
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    // Сеттеры для всех полей
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // Метод для хеширования пароля
    private String encodePassword(String rawPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(rawPassword);
    }

    // Метод для проверки введенного пароля
    public boolean checkPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches((CharSequence) password, (String) this.passwordHash);
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", passwordHash=" + passwordHash +
                '}';
    }
}



