package org.gpoup492project2.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

/**
  Автор Vladimir Romaikin
  Cohort49-2

  Класс Project представляет проект в системе управления проектами.
  Этот класс хранит информацию о проекте, его характеристиках, а также предоставляет методы для управления задачами в проекте.

  Основные поля:

  - id: Уникальный идентификатор проекта (будет присвоен после добавления в репозиторий).
  - title: Название проекта.
  - description: Описание проекта.
  - created: Дата создания проекта.
  - deadline: Дата завершения проекта.
  - priority: Приоритет проекта (использует константы из вложенного класса Priority).
  - status: Статус проекта (использует константы из вложенного класса Status).
  - executor: Ответственный пользователь за выполнение проекта.
  - tasks: Список задач, связанных с проектом (начально пустой).

  Основные методы:

  - addTask(Task task): Добавляет задачу в проект.
  - removeTask(Task task): Удаляет задачу из проекта.
  - Геттеры и сеттеры для доступа и обновления полей проекта.
  - toString(): Возвращает строковое представление объекта Project.
    Включает информацию о всех полях проекта, а также количество задач.
  - equals(Object o): Сравнивает текущий объект Project с другим объектом.
    Возвращает true, если объекты равны, false в противном случае.
  - hashCode(): Вычисляет хэш-код для объекта Project.
    Используется для корректного функционирования хэш-таблиц и других коллекций.
 */
public class Project {

    // Поля класса Project
    private String id;                // Уникальный идентификатор проекта (будет присвоен после добавления в репозиторий)
    private String title;             // Название проекта
    private String description;       // Описание проекта
    private LocalDate created;        // Дата создания проекта
    private LocalDate deadline;       // Дата завершения проекта
    private Priority priority;          // Приоритет проекта (использует константы из класса Priority)
    private Status status;            // Статус проекта (использует константы из класса Status)
    private User executor;            // Ответственный пользователь
    private List<Task> tasks;         // Список задач (начально пустой)
    private List<Comment> comments;   // Поле для хранения комментариев

    // Конструктор класса Project


    public Project(String id, String title, String description, LocalDate created, LocalDate deadline, Priority priority, Status status, User executor, List<Task> tasks, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
        this.executor = executor;
        this.tasks = tasks;
        this.comments = comments;
    }

    // Геттеры для доступа к полям проекта
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public User getExecutor() {
        return executor;
    }

    public List<Task> getTasks() {
        return new ArrayList<>(tasks); // Возвращаем копию списка задач
    }

    // Сеттеры для обновления данных проекта
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    // Метод toString для удобного вывода информации о проекте
    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", deadline=" + deadline +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", executor=" + executor.getName() + " " + executor.getSurname() +
                ", tasks=" + tasks.size() + " tasks" +
                '}';

    }
}