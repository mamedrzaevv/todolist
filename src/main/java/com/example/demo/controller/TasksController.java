package com.example.demo.controller;

import com.example.demo.dto.TasksDTO;
import com.example.demo.entity.TasksEntity;
import com.example.demo.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.time.LocalDate;

@RestController
@RequiredArgsConstructor

public class TasksController {
    private final TasksService tasksService;


    @PostMapping
    public ResponseEntity<TasksEntity> create(@RequestBody TasksDTO dto) {
        return new ResponseEntity<>(tasksService.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TasksEntity>> readAll() {
        return new ResponseEntity<>(tasksService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<TasksEntity> update(@RequestBody TasksEntity tasks) {
        return new ResponseEntity<>(tasksService.update(tasks), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        tasksService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<TasksEntity>> readByDate(@PathVariable("date") String dateString) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date;
        try {
            date = LocalDate.parse(dateString, format);
        } catch (DateTimeParseException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        List<TasksEntity> tasks = tasksService.readByDate(date);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}

