package org.gpoup492project2;

import org.gpoup492project2.Repository.ProjectRepository;
import org.gpoup492project2.Repository.TaskRepository;
import org.gpoup492project2.Repository.UserRepository;
import org.gpoup492project2.services.ProjectService;
import org.gpoup492project2.services.TaskService;
import org.gpoup492project2.services.UserService;
import org.gpoup492project2.services.UserInput;

public class UserAppDemo {
    public static void main(String[] args) {
//         Создаем сервисы (предполагается, что у них есть необходимые конструкторы)

        ProjectRepository projectRepository = new ProjectRepository();
        TaskRepository taskRepository = new TaskRepository();
        UserRepository userRepository = new UserRepository();

        ProjectService projectService = new ProjectService(projectRepository);
        TaskService taskService = new TaskService(taskRepository);
        UserService userService = new UserService(userRepository);
        UserInput userInput = new UserInput();


        // Создаем объект меню и запускаем его
        UserApp userApp = new UserApp(projectRepository, projectService, taskService, userService, userInput);
        userApp.menuStart();
    }
}
