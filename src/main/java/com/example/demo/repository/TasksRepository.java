package com.example.demo.repository;

import com.example.demo.entity.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, Integer> {
    List<Tasks> findByDate(LocalDate date);
}