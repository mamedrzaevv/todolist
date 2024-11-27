package com.example.demo.controller;

import com.example.demo.dto.TasksDTO;
import com.example.demo.entity.Tasks;
import com.example.demo.service.TasksService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.time.LocalDate;

@RestController
@AllArgsConstructor

public class TasksController {
    private final TasksService tasksService;


    @PostMapping
    public ResponseEntity<Tasks> create(@RequestBody TasksDTO dto) {
        return new ResponseEntity<>(tasksService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Tasks>> readAll() {
        return new ResponseEntity<>(tasksService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Tasks> update(@RequestBody Tasks tasks) {
        return new ResponseEntity<>(tasksService.update(tasks), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Integer id) {
        tasksService.delete(id);
        return HttpStatus.OK;
    }



        @GetMapping("/{date}")
        public ResponseEntity<List<Tasks>> readByDate(@PathVariable("date") String dateString) {
            LocalDate date = LocalDate.parse(dateString);
            List<Tasks> tasks = tasksService.readByDate(date);
            return new ResponseEntity<>(tasks, HttpStatus.OK);
        }
    }

