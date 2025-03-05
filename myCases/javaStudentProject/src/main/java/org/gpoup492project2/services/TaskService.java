package org.gpoup492project2.services;

import org.gpoup492project2.Repository.TaskRepository;
import org.gpoup492project2.dto.TaskDto;
import org.gpoup492project2.entity.Task;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public String createTask(TaskDto taskDto){

        // Валидируем входные данные
        if (!validateTaskDto(taskDto)) {
            return "Некорректные данные для создания задачи.";
        }

        // Проверяем, существует ли задача с таким ID
        if (!taskRepository.existsTaskById(taskDto.getTitle())) {
            return "Проект с названием " + taskDto.getTitle() + " уже существует.";
        }

        // Преобразуем DTO в объект Task
        Task task = taskDto.createTask();
        taskRepository.addTask(task);
        return "Задача " + task.getTitle() + " создана.";
    }

    // Метод для получения задачи по ID
    public Optional<Boolean> getTaskById(String idTask){
        boolean task = taskRepository.existsTaskById(idTask);
        return Optional.ofNullable(task);
    }

    // Метод для обновления задачи
    public String updateTask(TaskDto taskDto){
        // Валидируем входные данные
        if (!validateTaskDto(taskDto)){
            return "Некорректные данные для обновления задачи.";
        }
        // Проверяем, существует ли задача с таким ID
//        if (!taskRepository.existsTaskById(String.valueOf(taskDto.createTask()))){
//            return "Задача с ID " + taskDto.createTask();
//        }
        if (!taskRepository.existsTaskById(taskDto.getId())) {
            return "Задача с ID " + taskDto.getId() + " не найдена.";
        }

        // Преобразуем DTO в объект Task
        Task task = taskDto.createTask();
        taskRepository.updateTask(task);
        return "Задача " + task.getTitle() + " Обновлена";
    }

    // Метод для удаления задачи
    public String deleteTask(String taskToDelete){
        if (!taskRepository.existsTaskById(taskToDelete)){
            return "Задача с ID " + taskToDelete + " не найдена.";
        }
        taskRepository.deleteTask(taskToDelete);
        return "Задача с ID " + taskToDelete + " удалена.";
    }
    // Метод для получения всех задач
    public Map<String, Task> getAllTasks(){
        return taskRepository.getAllTasks();
    }

    // Метод для поиска задачи по названию
    public Optional<Task> findTaskByName(String name){
        List<Task> tasks = taskRepository.getAllTasks().values().stream()
                .filter(task -> task.getTitle().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        return tasks.isEmpty() ? Optional.empty() : Optional.of(tasks.get(0));
    }

//Недостающие методы
//    public Task createTask(TaskDto taskDto) {
//        Task task = new Task(taskDto.getTitle(), taskDto.getProjectId());
//        taskRepository.save(task);
//        return task;
//    }
//
//    public String updateTask(TaskDto taskDto) {
//        Task task = taskRepository.getTaskById(taskDto.getId());
//        if (task != null) {
//            task.setTitle(taskDto.getTitle());
//            task.setDescription(taskDto.getDescription());
//            task.setDeadline(taskDto.getDeadline());
//            task.setPriority(taskDto.getPriority());
//            task.setStatus(taskDto.getStatus());
//            taskRepository.save(task);
//            return "Задача обновлена.";
//        }
//        return "Задача не найдена.";
//    }
//
//    public void addCommentToTask(String taskId, Comment comment) {
//        Task task = taskRepository.getTaskById(taskId);
//        if (task != null) {
//            task.addComment(comment);
//            taskRepository.save(task);
//        }
//    }
//
//    public List<Comment> getCommentsByTaskId(String taskId) {
//        Task task = taskRepository.getTaskById(taskId);
//        if (task != null) {
//            return task.getComments();
//        }
//        return Collections.emptyList();
//    }
//
//    public void deleteCommentFromTask(String commentId) {
//        // Пример удаления комментария
//        taskRepository.getAllTasks().forEach(task -> {
//            task.getComments().removeIf(comment -> comment.getId().equals(commentId));
//            taskRepository.save(task);
//        });
//    }


    // Метод для валидации данных задачи
    private boolean validateTaskDto(TaskDto taskDto) {
        return taskDto.getTitle() != null && !taskDto.getTitle().isEmpty() &&
                taskDto.getDescription() != null &&
                taskDto.getCreated() != null &&
                taskDto.getDeadline() != null &&
                taskDto.getPriority() != null &&
                taskDto.getStatus() != null &&
                taskDto.getExecutor() != null;
    }
}
