package org.gpoup492project2.entity;

public enum Priority {
    HIGH("Приоритет высокий"),
    MEDIUM("Средний приоритет"),
    LOW("Приоритет низкий");

    private final String description;

    Priority(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}