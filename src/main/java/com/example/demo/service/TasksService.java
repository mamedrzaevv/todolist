package com.example.demo.service;

import com.example.demo.dto.TasksDTO;
import com.example.demo.entity.TasksEntity;
import com.example.demo.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.time.LocalDate;

@Service
public class TasksService {

    private final TasksRepository tasksRepository;

    @Autowired
    public TasksService(TasksRepository tasksRepository) {
        this.tasksRepository = tasksRepository;
    }

    public TasksEntity create(TasksDTO dto) {
        TasksEntity tasksEntity = new TasksEntity(
                dto.getTitle(),
                dto.getObj(),
                dto.getDate()
        );
        return tasksRepository.save(tasksEntity);
    }

    public List<TasksEntity> readAll() {
        return tasksRepository.findAll();
    }

    public TasksEntity update(TasksEntity tasks) {
        Integer id = tasks.getId();
        if (!tasksRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return tasksRepository.save(tasks);
    }

    public void delete(Integer id) {
        if (!tasksRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        tasksRepository.deleteById(id);
    }


    public List<TasksEntity> readByDate(LocalDate date) {
        return tasksRepository.findByDate(date);
    }
}
