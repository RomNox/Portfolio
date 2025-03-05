//package org.gpoup492project2;
//
//import org.gpoup492project2.dto.ProjectDto;
//import org.gpoup492project2.dto.TaskDto;
//import org.gpoup492project2.entity.*;
//import org.gpoup492project2.services.ProjectService;
//import org.gpoup492project2.services.TaskService;
//import org.gpoup492project2.services.UserInput;
//import org.gpoup492project2.services.UserService;
//
//import java.time.LocalDate;
//import java.util.Map;
//import java.util.Optional;
//
//public class UserMenu {
//          private ProjectService projectService;
//          private TaskService taskService;
//          private UserService userService;
//          private UserInput userInput;
//
//            public UserMenu(ProjectService projectService, TaskService taskService, UserService userService) {
//                this.projectService = projectService;
//                this.taskService = taskService;
//                this.userService = userService;
//            }
//
//            public void menuStart() {
//                while (true) {
//                    System.out.println("Главное Меню:");
//                    System.out.println("1. Создать проект");
//                    System.out.println("2. Просмотреть все проекты");
//                    System.out.println("3. Управлять проектом");
//                    System.out.println("4. Выйти из программы");
//
//                    int userChoose = userInput.inputInt("Выберите пункт меню: ");
//
//                    switch (userChoose) {
//                        case 1:
//                            // Создание проекта
//                            String title = userInput.inputText("Введите название проекта: ");
//                            String description = userInput.inputText("Введите описание проекта: ");
//                            String deadlin = userInput.inputText("Введите дедллайн проекта (yyyy-mm-dd): ");
//                            Priority newProjectPriority = userInput.inputPriority("Выбери один из приоритетов проекта (HIGH / IMEDIUM / LOW) и введи его: " );
//                            Status newProjectStatus = userInput.inputStatus("Выбери один из статусув проекта (NOT_STARTED / IN_PROGRESS / COMPLETED) и введи его: " );
//                            // Получаем исполнителя
//                            int executorId = userInput.inputInt("Введите ID исполнителя: ");
//                            User executor = userService.getUserById(executorId);
//                            if (executor == null) {
//                                System.out.println("Исполнитель не найден.");
//                                break;
//                            }
//                            ProjectDto projectDto = new ProjectDto(title, description, LocalDate.parse(deadlin), new Priority, newProjectStatus, executor);
//                            String newProject = projectService.createProject(projectDto);
//                            if (newProject != null){
//                                System.out.println("Успешно добавлен новый проект.");
//                                System.out.println(newProject);
//                            } else {
//                                System.out.println("Проект добавить не удалось.");
//                            }
//                            break;
//
//                        case 2:
//                            // Просмотр всех проектов
//                            Map<String, Project> allProjects = projectService.getAllProjects();
//                            if (allProjects.isEmpty()) {
//                                System.out.println("Проект не найден");
//                            } else {
//                                allProjects.values().forEach(System.out::println);
//                            }
//                            break;
//
//                        case 3:
//                            // Управление проектом
//                            System.out.println("3.1 Просмотреть информацию о проекте");
//                            System.out.println("3.2 Добавить задачу");
//                            System.out.println("3.3 Редактировать задачу");
//                            System.out.println("3.4 Удалить задачу");
//                            System.out.println("3.5 Изменить информацию о проекте");
//                            System.out.println("3.6 Назначить ответственного за проект");
//
//                            int subChoose = userInput.inputInt("Выберите пункт подменю: ");
//
//                            switch (subChoose) {
//                                // Просмотр информации о проекте
//                                case 1:
//                                    ProjectDto projectId = userInput.inputText("Введите id проекта: ");
//                                    Optional <Project> project = projectService.getProjectById(projectId);
//                                    if (project != null) {
//                                        System.out.println("Информация о проекте: " + project);
//                                    } else {
//                                        System.out.println("Проект не найден");
//                                    }
//                                    break;
//                                case 2:
//                                    // Добавление задачи
//                                    String taskProjectId = userInput.inputText("Введите id проекта для добавления задачи: ");
//                                    String newTaskTitle = userInput.inputText("Введите название задачи: ");
//                                    Status newTaskStatus = userInput.inputStatus("Выбери один из статусув задачи (NOT_STARTED / IN_PROGRESS / COMPLETED) и введи его: " );
//                                    Priority newTaskPriority = userInput.inputPriority("Выбери один из приоритетов задачи (HIGH / IMEDIUM / LOW) и введи его: " );
//                                    // по идее тут нужно добавить все что у нас в дто
//                                    Task newTask = taskService.createTask(new TaskDto(newTaskTitle, taskProjectId,);
//                                    if (newTask != null) {
//                                        System.out.println("Задача добавлена" + newTask);
//                                    } else {
//                                        System.out.println("Не удалось добавить задачу");
//                                    }
//                                    break;
//                                case 3:
//                                    // Редактирование задачи
//                                    ProjectDto taskIdToUpdate = userInput.inputText("Введите id задачи для редактирования: ");
//                                    //Task updatedTask = taskService.updateTask(taskIdToUpdate);
//                                    Task updatedTask = taskService.updateTask(taskIdToUpdate)
//                                    if (updatedTask != null) {
//                                        System.out.println("Задача отредактирована " + updatedTask);
//                                    } else {
//                                        System.out.println("Не удалось отредактировать задачу");
//                                    }
//                                    break;
//                                case 4:
//                                    // Удаление задачи
//                                    ProjectDto taskIdToDelete = userInput.inputText("Введите id задачи для удаления: ");
//
//                                    String deleteResult = taskService.deleteTask(taskIdToDelete);
//                                    System.out.println(deleteResult);
//                                    break;
//                                case 5:
//                                    // Изменение информации о проекте
//                                    ProjectDto projectIdToUpdate = userInput.inputText("Введите id проекта для редактирования: ");
//                                    String updateProject = projectService.updateProject(projectIdToUpdate);
//                                    if (updateProject != null) {
//                                        System.out.println("Проект обновлен " + updateProject);
//                                    } else {
//                                        System.out.println("Не удалось изменить информацию о проекте");
//                                    }
//                                    break;
//                                case 6:
//                                    // Назначение ответственного за проект
//                                    ProjectDto projectIdForExecutor = userInput.inputText("Введите id проекта для назначения ответственного: ");
//                                    ProjectDto userId = userInput.inputText("Введите id пользователя для назначения: ");
//                                    User executorForProject = userService.getUserById(userId);
//                                    projectService.assignExecutor(projectIdForExecutor, executorForProject);
//                                    if (executorForProject != null) {
//                                        System.out.println("Ответственный назначен");
//                                    } else {
//                                        System.out.println("Ответственного назначить не удалось");
//                                    }
//                                    break;
//                                default:
//                                    System.out.println("Неверный пункт подменю. Пожалуйста, попробуйте снова.");
//
//                            break;
//                        case 4:
//                            System.out.println("Выход из программы.");
//                            return;
//                        default:
//                            System.out.println("Неверный пункт меню. Пожалуйста, попробуйте снова.");
//                    }
//                }
//            }
//        }