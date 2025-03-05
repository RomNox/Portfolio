package org.gpoup492project2;
import org.gpoup492project2.Repository.ProjectRepository;
import org.gpoup492project2.dto.ProjectDto;
import org.gpoup492project2.dto.TaskDto;
import org.gpoup492project2.dto.UserDto;
import org.gpoup492project2.entity.*;
import org.gpoup492project2.services.ProjectService;
import org.gpoup492project2.services.TaskService;
import org.gpoup492project2.services.UserInput;
import org.gpoup492project2.services.UserService;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
public class UserApp {
    private ProjectRepository projectRepository;
    private ProjectService projectService;
    private TaskService taskService;
    private UserService userService;
    private UserInput userInput;


    public UserApp(ProjectRepository projectRepository, ProjectService projectService, TaskService taskService, UserService userService, UserInput userInput) {
        this.projectRepository = projectRepository;
        this.projectService = projectService;
        this.taskService = taskService;
        this.userService = userService;
        this.userInput = userInput;
    }

    public void menuStart() {
        while (true) {
            System.out.println("Главное Меню:");
            System.out.println("1. Создать пользователя:");
            System.out.println("2. Создать проект");
            System.out.println("3. Просмотреть все проекты");
            System.out.println("4. Управлять проектом");
            System.out.println("5. Выйти из программы");
            int userChoose = userInput.inputInt("Выберите пункт меню: ");
            switch (userChoose) {
                case 1:
                    // Создание пользователя
                    String name = userInput.inputText("Введите имя пользователя: ");
                    String surname = userInput.inputText("Введите фамилию пользователя: ");
                    String login = userInput.inputText("Введите логин пользователя: ");
                    String password = userInput.inputText("Введите пароль пользователя: ");
                    // Создание нового объекта User
                    //UserDto newUser = new UserDto(name, surname, login, password);
                    // Сохранение пользователя в системе (этот метод нужно будет реализовать в зависимости от вашей системы хранения)
                    User newUser = userService.addUser(name, surname, login, password);
                    System.out.println("Пользователь " + newUser + " успешно добавлен.");

                    break;
//            private void saveUser(User user) {
//            }






                case 2:
                    // Создание проекта
                    String title = userInput.inputText("Введите название проекта: ");
                    String description = userInput.inputText("Введите описание проекта: ");
                    String created = userInput.inputText("Введите дату создания проекта: ");
                    String deadline = userInput.inputText("Введите дедлайн проекта (yyyy-mm-dd): ");
                    Priority newProjectPriority = userInput.inputPriority("Выбери один из приоритетов проекта (HIGH / MEDIUM / LOW) и введи его: ");
                    Status newProjectStatus = userInput.inputStatus("Выбери один из статусов проекта (NOT_STARTED / IN_PROGRESS / COMPLETED) и введи его: ");
                    // Получаем исполнителя
                    int executorId = userInput.inputInt("Введите ID исполнителя: ");
                    User executor = userService.getUserById(executorId);
                    if (executor == null) {
                        System.out.println("Исполнитель не найден.");
                        break;
                    }
                    ProjectDto projectDto = new ProjectDto(title, description, LocalDate.parse(created) ,LocalDate.parse(deadline), newProjectPriority, newProjectStatus, executor);
                    String newProject = projectService.createProject(projectDto);
                    System.out.println(newProject);
                    break;
                case 3:
                    // Просмотр всех проектов
                    Map<String, Project> allProjects = projectService.getAllProjects();
                    if (allProjects.isEmpty()) {
                        System.out.println("Проект не найден");
                    } else {
                        allProjects.values().forEach(project -> System.out.println("ID: " + project.getId() + ", Название: " + project.getTitle()));
                    }
                    break;
                case 4:
                    // Управление проектом
                    System.out.println("3.1 Просмотреть информацию о проекте");
                    System.out.println("3.2 Добавить задачу");
                    System.out.println("3.3 Редактировать задачу");
                    System.out.println("3.4 Удалить задачу");
                    System.out.println("3.5 Изменить информацию о проекте");
                    System.out.println("3.6 Назначить ответственного за проект");
                    int subChoose = userInput.inputInt("Выберите пункт подменю: ");
                    switch (subChoose) {
                        case 1:
                            String projectId = userInput.inputText("Введите id проекта: ");
                            Optional<Project> projectOptional = projectService.getProjectById(String.valueOf(projectId)); // исправлено с ProjectDto на String
                            if (projectOptional.isPresent()) {
                                System.out.println("Информация о проекте: " + projectOptional.get());
                            } else {
                                System.out.println("Проект не найден");
                            }
                            break;
                        case 2:
                            //String taskProjectId = String.valueOf(userInput.inputText("Введите ID проекта для добавления задачи: "));
                            String newTaskTitle = String.valueOf(userInput.inputText("Введите название задачи: "));
                            String newTaskDescription = String.valueOf(userInput.inputText("Введите описание задачи: "));
                            String newTaskCreated = userInput.inputText("Введите дату создания задачи: ");
                            String newTaskDeadline = userInput.inputText("Введите дедлайн задачи (yyyy-mm-dd): ");
                            //String newTaskCreated = String.valueOf(userInput.inputText("Введите дату создания задачи: "));
                            //String newTaskDeadline = String.valueOf(userInput.inputText("Введите дату окончания задачи: "));
                            Priority newTaskPriority = userInput.inputPriority("Выбери один из приоритетов задачи (HIGH / MEDIUM / LOW) и введи его: ");
                            Status newTaskStatus = userInput.inputStatus("Выбери один из статусов задачи (NOT_STARTED / IN_PROGRESS / COMPLETED) и введи его: ");
                            int newExecutorId = userInput. inputInt("Введите ID исполнителя: ");
                            User newTaskExecutor = userService.getUserById(newExecutorId);
                            //TaskDto newTaskComments = //userInput.inputText("Напишите коментарий");
                            TaskDto task;
                            List newTaskComments = Collections.singletonList(userInput.inputText("Введите коментарий"));
                            task = new TaskDto(newTaskTitle, newTaskDescription, LocalDate.parse(newTaskCreated), LocalDate.parse(newTaskDeadline), newTaskPriority, newTaskStatus, newTaskExecutor, newTaskComments);
                            String newTask = taskService.createTask(task);
                            if (newTask != null) {
                                System.out.println("Задача добавлена: " + newTask);
                            } else {
                                System.out.println("Не удалось добавить задачу");
                            }
                            break;
                        case 3:
//                            String taskIdToUpdate = userInput.inputText("Введите ID задачи для редактирования: ");
//                            TaskDto updatedTask = taskService.updateTask(taskIdToUpdate);
//                            if (updatedTask != null) {
//                                System.out.println("Задача отредактирована: " + updatedTask);
//                            } else {
//                                System.out.println("Не удалось отредактировать задачу");
//                            }
                            String taskIdToUpdate = userInput.inputText("Введите ID задачи для редактирования: ");
                            String newTitle = userInput.inputText("Введите новое название задачи: ");
                            String newDescription = userInput.inputText("Введите новое описание задачи: ");
                            LocalDate newDeadline = LocalDate.parse(userInput.inputText("Введите новый дедлайн задачи (yyyy-mm-dd): "));
                            Priority newPriority = userInput.inputPriority("Выберите новый приоритет задачи (HIGH / MEDIUM / LOW): ");
                            Status newStatus = userInput.inputStatus("Выберите новый статус задачи (NOT_STARTED / IN_PROGRESS / COMPLETED): ");
                            int newExecutorId1 = userInput.inputInt("Введите ID исполнителя: ");
                            User newExecutor = userService.getUserById(newExecutorId1);

                            TaskDto updatedTaskDto = new TaskDto(newTitle, newDescription, LocalDate.now(), newDeadline, newPriority, newStatus, newExecutor, Collections.emptyList());
                            updatedTaskDto.setId(taskIdToUpdate); // Устанавливаем ID задачи для обновления
                            String updateResult = taskService.updateTask(updatedTaskDto);

                            System.out.println(updateResult);
                            break;
                        case 4:
                            String taskIdToDelete = userInput.inputText("Введите ID задачи для удаления: ");
                            String deleteResult = taskService.deleteTask(taskIdToDelete);
                            System.out.println(deleteResult);
                            break;
                        case 5:
//                            String projectIdToUpdate = String.valueOf(userInput.inputText("Введите ID проекта для редактирования: "));
//                            ProjectDto updatedProjectDto = projectService.updateProject(projectIdToUpdate);
//                            if (updatedProjectDto != null) {
//                                System.out.println("Проект обновлен: " + updatedProjectDto);
//                            } else {
//                                System.out.println("Не удалось изменить информацию о проекте");
//                            }
//                            break;
                        case 6:
                            String projectIdForExecutor = String.valueOf(userInput.inputText("Введите ID проекта для назначения ответственного: "));
                            int userId = userInput.inputInt("Введите ID пользователя для назначения: ");
                            User executorForProject = userService.getUserById(userId);
                            if (executorForProject != null) {
                                projectService.assignExecutor(projectIdForExecutor, executorForProject);
                                System.out.println("Ответственный назначен");
                            } else {
                                System.out.println("Ответственного назначить не удалось");
                            }
                            break;
                        default:
                            System.out.println("Неверный пункт подменю. Пожалуйста, попробуйте снова.");
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный пункт меню. Пожалуйста, попробуйте снова.");
            }
        }
    }
}