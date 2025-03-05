package org.gpoup492project2.entity;

public enum Status {
    NOT_STARTED("Не начат"),
    IN_PROGRESS("В работе"),
    COMPLETED("Завершен");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
