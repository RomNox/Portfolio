package org.gpoup492project2.Repository;

import org.gpoup492project2.entity.Project;

import java.util.HashMap;
import java.util.Map;

public class ProjectRepository {
    private Map<String, Project> projectMap = new HashMap<>();

    private Integer idCounter = 0;

    public String addProject(Project project) {
        idCounter++; // увеличиваем счетчик проектов
        project.setId(idCounter.toString());// Устанавливаем ID в объекте Project
        projectMap.put(idCounter.toString(), project); // положили проект в коллекцию
        return idCounter.toString(); // вернули номер проекта
    }

    // Метод для получения проекта по идентификатору
    public Project getProjectById(String id) {
        return projectMap.get(id);
    }
    // Метод для обновления проекта
    public Project updateProject(Project updateProject) {
        return projectMap.put(updateProject.getId(), updateProject);
    }

    // Метод для удаления проекта
    public void deleteProject(String id) {
        projectMap.remove(id);
    }

    // Метод для получения всех проектов
    public Map<String, Project> getAllProjects() {
        return projectMap;
    }

    // Метод поиска по ID
    public boolean existsProjectById(String id) {
        return projectMap.containsKey(id);
    }
    // Метод поиска по названию
    public boolean existsProjectByName(String name) {
        for (Project project : projectMap.values()) {
            if (project.getTitle().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
