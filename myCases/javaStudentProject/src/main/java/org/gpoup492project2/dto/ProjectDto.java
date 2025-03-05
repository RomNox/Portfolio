/**
 * Data Transfer Object (DTO) для Project.
 * Используется для передачи данных пользователя между слоями приложения.
 * Позволяет собирать данные из пользовательского ввода и создавать объект Project.
 */

package org.gpoup492project2.dto;

import org.gpoup492project2.entity.Project;
import org.gpoup492project2.entity.Task;
import org.gpoup492project2.entity.User;
import org.gpoup492project2.entity.Priority;
import org.gpoup492project2.entity.Status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjectDto {

    // Поля DTO, соответствующие полям класса Project
    private String title;                      // Название проекта
    private String description;                // Описание проекта
    private LocalDate created;                 // Дата создания проекта
    private LocalDate deadline;                // Дата завершения проекта
    private Priority priority;                 // Приоритет проекта
    private Status status;                     // Статус проекта
    private User executor;                     // Ответственный пользователь
    private List<Task> tasks;                  // Список задач

    // Конструктор для инициализации всех полей
    public ProjectDto(String title, String description, LocalDate created, LocalDate deadline, Priority priority, Status status, User executor) {
        this.title = title;
        this.description = description;
        this.created = created;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
        this.executor = executor;
        this.tasks = new ArrayList<>();  // Инициализируем список задач пустым
    }

    // Преобразование DTO в объект Project
    public Project toProject() {
        return new Project(null, this.title, this.description, this.created, this.deadline,
                this.priority, this.status, this.executor,this.tasks,new ArrayList<>());
    }

    // Геттеры и сеттеры для всех полей

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}






