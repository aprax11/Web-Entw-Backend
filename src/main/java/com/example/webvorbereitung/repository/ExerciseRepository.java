package com.example.webvorbereitung.repository;

import com.example.webvorbereitung.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    List<Exercise> findByBodypart(String bodypart);
    List<Exercise> findByTitle(String title);
}
