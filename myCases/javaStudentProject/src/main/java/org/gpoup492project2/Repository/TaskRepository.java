package org.gpoup492project2.Repository;

import org.gpoup492project2.dto.TaskDto;
import org.gpoup492project2.entity.Project;
import org.gpoup492project2.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TaskRepository {
    private Map<String, Task> taskStorage = new HashMap<>();

    private Integer idCounter = 0;

    // Метод для добавления задачи
    public String addTask(Task task) {
        idCounter++;// увеличиваем счетчик задач
        task.setId (idCounter.toString());// Устанавливаем ID в объекте Task
        taskStorage.put(idCounter.toString(), task); // положили Task в коллекцию
        return idCounter.toString(); // вернули номер задачи
        //taskStorage.put(task.getTitle(), task);
    }

    // Метод для получения задачи по идентификатору
    public boolean existsTaskById(String id) {
        return taskStorage.containsKey(id);
    }

    // Метод для обновления задачи
    public void updateTask(Task taskToUpdate) {
        taskStorage.put(String.valueOf(taskToUpdate.getId()), taskToUpdate);
    }

    // Метод для удаления задачи
    public void deleteTask(String taskId) {
        taskStorage.remove(taskId);
    }

    // Метод для получения списка всех задач
    public Map<String, Task> getAllTasks() {
        return taskStorage;
    }

    public List<Task> getTasksByStatus(String status) {
        return taskStorage.values().stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }
}
