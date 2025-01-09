package com.example.demo.dto;

import java.time.LocalDate;

public final class TasksDTO {

    private String title;
    private String obj;
    private LocalDate date;

    public String getTitle() {
        return title;
    }

    public String getObj() {
        return obj;
    }

    public LocalDate getDate() {
        return date;
    }
}