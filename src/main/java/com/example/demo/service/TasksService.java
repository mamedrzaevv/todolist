package com.example.demo.service;

import com.example.demo.dto.TasksDTO;
import com.example.demo.entity.Tasks;
import com.example.demo.repository.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;


    public Tasks create(TasksDTO dto) {
        return tasksRepository.save(Tasks.builder()
                .title(dto.getTitle())
                .obj(dto.getObj())
                .date(dto.getDate())
                .build());
    }

    public List<Tasks> readAll() {
        return tasksRepository.findAll();
    }

    public Tasks update(Tasks tasks) {
        return tasksRepository.save(tasks);
    }
    public void delete(Integer id) {
        tasksRepository.deleteById(id);
    }


    public List<Tasks> readByDate(LocalDate date) {
        return tasksRepository.findByDate(date);
    }
}
