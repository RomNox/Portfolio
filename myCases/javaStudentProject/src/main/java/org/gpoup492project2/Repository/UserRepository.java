package org.gpoup492project2.Repository;


import org.gpoup492project2.entity.Project;
import org.gpoup492project2.entity.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private Map<Integer, User> userMap = new HashMap<>();

    private Integer idCounter = 0;
    // Метод для добавления пользователя
    public String addUser(User user) {
        idCounter++; // увеличиваем счетчик пользователей
        user.setId(idCounter); // Устанавливаем ID в объекте User
        userMap.put(idCounter, user); // положили user в коллекцию
        return idCounter.toString(); // вернули номер пользователя
    }

    // Метод для получения пользователя по идентификатору
    public User getUserById(Integer id) {
        return userMap.get(id);
    }

    // Метод для обновления пользователя
    public void updateUser(User user) {
        userMap.put(user.getId(), user);
    }

    // Метод для удаления пользователя
    public void deleteUser(Integer id) {

    }
    // Метод для получения всех пользователей
    public Map<Integer, User> getAllUsers() {
        return userMap;
    }

//    public void save(User user) {
//    }

    // Метод поиска по названию
    public boolean existsUserByName(String name) {
        for (User user : userMap.values()) {
            if (user.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
