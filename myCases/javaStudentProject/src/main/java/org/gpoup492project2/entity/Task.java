package org.gpoup492project2.entity;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
  Автор Vladimir Romaikin
  Cohort49-2

  Класс Task представляет задачу в системе управления проектами.
  Этот класс хранит информацию о задаче, её характеристиках и предоставляет методы для её управления.

  Основные поля:

  - id: Уникальный идентификатор задачи.
  - title: Название задачи.
  - description: Описание задачи.
  - created: Дата создания задачи.
  - deadline: Дата выполнения задачи.
  - priority: Приоритет задачи (например, высокий, средний, низкий).
  - status: Статус задачи (например, в работе, завершена, ожидает).
  - executor: Ответственный пользователь за выполнение задачи.

  Основные методы:

  - editTask(String newTitle, String newDescription, LocalDate newDeadline,
  - String newPriority, String newStatus): Обновляет информацию о задаче,
    включая название, описание, дату выполнения, приоритет и статус.
  - Геттеры и сеттеры для доступа и обновления полей задачи.
  - toString(): Возвращает строковое представление объекта Task.
    Включает информацию о всех полях задачи.
  - equals(Object o): Сравнивает текущий объект Task с другим объектом.
    Возвращает true, если объекты равны, false в противном случае.
  - hashCode(): Вычисляет хэш-код для объекта Task.
    Используется для корректного функционирования хэш-таблиц и других коллекций.
 */

public class Task {

    // Список для статусов задачи
    public static final String STATUS_IN_PROGRESS = "В работе";
    public static final String STATUS_COMPLETED = "Завершена";
    public static final String STATUS_PENDING = "Ожидает";

    // Список для приоритетов задачи
    public static final String PRIORITY_HIGH = "Приоритет высокий";
    public static final String PRIORITY_MEDIUM = "Средний приоритет";
    public static final String PRIORITY_LOW = "Приоритет низкий";

    // Поля класса Task
    private String id;                // Уникальный идентификатор задачи
    private String title;             // Название задачи
    private String description;       // Описание задачи
    private LocalDate created;        // Дата создания задачи
    private LocalDate deadline;       // Дата выполнения задачи
    private Priority priority;          // Приоритет задачи (например, высокий, средний, низкий)
    private Status status;            // Статус задачи (например, в работе, завершена, ожидает)
    private User executor;            // Ответственный пользователь
    private List<Comment> comments;   // Добавлено для хранения комментариев

    // Конструктор класса Task
    public Task(String id, String title, String description, LocalDate created, LocalDate deadline, Priority priority, Status status, User executor, List<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.created = created;
        this.deadline = deadline;
        this.priority = priority;
        this.status = status;
        this.executor = executor;
        this.comments = comments;
    }

    // Геттеры для доступа к полям задачи
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Comment> getComments() {
        return comments;
    }

    // Сеттеры для обновления данных задачи
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

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    // Метод для редактирования задачи
    public void editTask(String newTitle, String newDescription, LocalDate newDeadline, Priority newPriority, Status newStatus) {
        // Обновляем поля задачи
        this.title = newTitle;
        this.description = newDescription;
        this.deadline = newDeadline;
        this.priority = newPriority;
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", deadline=" + deadline +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", executor=" + executor +
                ", comments=" + comments +
                '}';
    }

    // Метод equals для сравнения двух объектов Task
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(id, task.id) &&
                Objects.equals(title, task.title) &&
                Objects.equals(description, task.description) &&
                Objects.equals(created, task.created) &&
                Objects.equals(deadline, task.deadline) &&
                Objects.equals(priority, task.priority) &&
                Objects.equals(status, task.status) &&
                Objects.equals(executor, task.executor);
    }

    // Метод hashCode для вычисления уникального хэш-кода объекта Task
    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, created, deadline, priority, status, executor);
    }
}



