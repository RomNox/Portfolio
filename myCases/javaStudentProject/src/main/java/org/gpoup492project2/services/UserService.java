package org.gpoup492project2.services;

import org.gpoup492project2.Repository.UserRepository;
import org.gpoup492project2.entity.User;

import java.util.Map;

public class UserService {
    private UserRepository userRepository;

    //Конструктор
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Метод для создания пользователя
    public User addUser(String name, String surname, String login, String password) {
        User user = new User(name, surname, login, password);
        userRepository.addUser(user);
        return user;
    }

    // Метод для получения пользователя по id
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    // Метод для получения пользователя по логину
    public User getUserByLogin(String login) {
        for (User user : userRepository.getAllUsers().values()) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null; // если пользователь не найден
    }

    // Метод для удаления пользователя по id
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }

    // Метод для аутентификации пользователя
    public boolean authenticateUser(String login, String password) {
        User user = getUserByLogin(login);
        if (user != null) {
            return user.checkPassword(password);
        }
        return false; // если пользователь не найден
    }

    // Метод для получения всех пользователей
    public Map<Integer, User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}

