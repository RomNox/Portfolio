package org.gpoup492project2.services;

import org.gpoup492project2.Repository.ProjectRepository;
import org.gpoup492project2.entity.Project;
import org.gpoup492project2.entity.Task;
import org.gpoup492project2.dto.ProjectDto;
import org.gpoup492project2.entity.Comment;
import org.gpoup492project2.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Сервисный класс для управления проектами.
 * Этот класс предоставляет методы для создания, обновления, удаления и получения проектов,
 * а также для добавления и удаления задач и комментариев в проекте. Использует репозиторий ProjectRepository
 * для взаимодействия с данными проектов.
 */

public class ProjectService {

  // Репозиторий для работы с проектами
  private final ProjectRepository projectRepository;

  // Конструктор, который получает репозиторий для работы
  public ProjectService(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  //Создание проекта из DTO.
  public String createProject(ProjectDto projectDto) {
    // Валидируем входные данные
    if (!validateProjectDto(projectDto)) {
      return "Некорректные данные для создания проекта.";
    }

    // Проверяем, существует ли проект с таким названием
    if (projectRepository.existsProjectByName(projectDto.getTitle())) {
      return "Проект с названием " + projectDto.getTitle() + " уже существует.";
    }

    // Преобразуем DTO в объект Project
    Project project = projectDto.toProject();

    // Добавляем проект в репозиторий и сохраняем его
    String generatedId = projectRepository.addProject(project);  // Получаем ID, возвращённый репозиторием

    // Возвращаем сообщение об успешном создании проекта
    return "Проект " + project.getTitle() + " создан с ID " + generatedId + ".";
  }

  //Получение проекта по ID.
  public Optional<Project> getProjectById(String id) {
    return Optional.ofNullable(projectRepository.getProjectById(id));
  }

  //Обновление проекта.
  public String updateProject(ProjectDto projectDto) {
    // Валидируем входные данные
    if (!validateProjectDto(projectDto)) {
      //return "Некорректные данные для обновления проекта.";
      return "Некорректные данные для обновления проекта.";
    }

    // Проверяем, существует ли проект с таким названием
    if (!projectRepository.existsProjectById(projectDto.toProject().getId())) {
      return "Проект с ID " + projectDto.toProject().getId() + " не найден.";
    }

    // Преобразуем DTO в объект Project
    Project project = projectDto.toProject();

    // Обновляем проект в репозитории
    projectRepository.updateProject(project);

    // Возвращаем сообщение об успешном обновлении проекта
    return "Проект " + project.getTitle() + " обновлён.";
  }

  //Удаление проекта по ID.
  public String deleteProject(String id) {
    if (!projectRepository.existsProjectById(id)) {
      return "Проект с ID " + id + " не найден.";
    }
    projectRepository.deleteProject(id);
    return "Проект с ID " + id + " удалён.";
  }

  //Получение всех проектов.
  public Map<String, Project> getAllProjects() {
    return projectRepository.getAllProjects();
  }

  //Поиск проекта по названию.
  public Optional<Project> findProjectByName(String name) {
    List<Project> projects = projectRepository.getAllProjects().values().stream()
            .filter(project -> project.getTitle().equalsIgnoreCase(name))
            .collect(Collectors.toList());
    return projects.isEmpty() ? Optional.empty() : Optional.of(projects.get(0));
  }

  //Добавление задачи к проекту.
  public String addTaskToProject(String projectId, Task task) {
    Project project = projectRepository.getProjectById(projectId);
    if (project == null) {
      return "Проект с ID " + projectId + " не найден.";
    }
    project.getTasks().add(task); //перенос в проект
    return "Задача " + task.getTitle() + " добавлена к проекту " + project.getTitle() + ".";
  }

  //Удаление задачи из проекта.
  public String removeTaskFromProject(String projectId, String taskId) {
    Project project = projectRepository.getProjectById(projectId);
    if (project == null) {
      return "Проект с ID " + projectId + " не найден.";
    }
    Task taskToRemove = project.getTasks().stream()
            .filter(task -> task.getId().equals(taskId))
            .findFirst()
            .orElse(null);
    if (taskToRemove == null) {
      return "Задача с ID " + taskId + " не найдена в проекте " + project.getTitle() + ".";
    }
    project.getTasks().remove(taskToRemove);
    return "Задача с ID " + taskId + " удалена из проекта " + project.getTitle() + ".";
  }

  //Добавление комментария к проекту.
  public String addCommentToProject(String projectId, Comment comment) {
    Project project = projectRepository.getProjectById(projectId);
    if (project == null) {
      return "Проект с ID " + projectId + " не найден.";
    }
    project.getComments().add(comment);
    return "Комментарий добавлен к проекту " + project.getTitle() + ".";
  }

  //Удаление комментария из проекта.
  public String removeCommentFromProject(String projectId, String commentId) {
    Project project = projectRepository.getProjectById(projectId);
    if (project == null) {
      return "Проект с ID " + projectId + " не найден.";
    }
    Comment commentToRemove = project.getComments().stream()
            .filter(comment -> comment.getId().equals(commentId))
            .findFirst()
            .orElse(null);
    if (commentToRemove == null) {
      return "Комментарий с ID " + commentId + " не найден в проекте " + project.getTitle() + ".";
    }
    project.getComments().remove(commentToRemove);
    return "Комментарий с ID " + commentId + " удалён из проекта " + project.getTitle() + ".";
  }

  //Недостающие методы
//  public Project updateProjectTitle(String projectId, String newTitle) {
//    Project project = projectRepository.getProjectById(projectId);
//    if (project != null) {
//      project.setTitle(newTitle);
//      projectRepository.save(project);
//      return project;
//    }
//    return null;
//  }
//
//  public void assignExecutor(String projectId, User executor) {
//    Project project = projectRepository.getProjectById(projectId);
//    if (project != null) {
//      project.setExecutor(executor);
//      projectRepository.save(project);
//    }
//  }

  //Валидация данных проекта.
  private boolean validateProjectDto(ProjectDto projectDto) {
    return projectDto.getTitle() != null && !projectDto.getTitle().isEmpty() &&
            projectDto.getDescription() != null &&
            projectDto.getCreated() != null &&
            projectDto.getDeadline() != null &&
            projectDto.getPriority() != null &&
            projectDto.getStatus() != null &&
            projectDto.getExecutor() != null;
  }

  public void assignExecutor(String projectIdForExecutor, User executorForProject) {

  }
}





