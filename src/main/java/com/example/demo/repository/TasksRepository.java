package com.example.demo.repository;

import com.example.demo.entity.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Integer> {
    List<TasksEntity> findByDate(LocalDate date);
}