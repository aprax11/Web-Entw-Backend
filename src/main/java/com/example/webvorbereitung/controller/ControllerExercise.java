package com.example.webvorbereitung.controller;


import com.example.webvorbereitung.model.Exercise;
import com.example.webvorbereitung.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ControllerExercise {
    @Autowired
    ExerciseRepository exerciseRepository;
    @GetMapping("/exercises")
    public List<Exercise> getAllExercises() {
		return exerciseRepository.findAll();
    }

    @PostMapping("/exercises")
    public Exercise createExercise(@RequestBody Exercise exercise) {
		return exerciseRepository.save(new Exercise(exercise.getTitle(), exercise.getBodypart(), exercise.getDifficulty(), exercise.getComment()));
    }
    @PutMapping("/exercises/{id}")
    public void updateExercise(@PathVariable("id") long id, @RequestBody Exercise exercise) {
		this.exerciseRepository.findById(id).map(exercise1 -> {
            exercise1.setTitle(exercise.getTitle());
            exercise1.setBodypart(exercise.getBodypart());
            exercise1.setDifficulty(exercise.getDifficulty());
            exercise1.setComment(exercise.getComment());
            return exerciseRepository.save(exercise1);
        });
    }
    @PatchMapping("/exercises/{id}")
    public void patchComment(@PathVariable("id") long id, @RequestBody Exercise exercise) {
        this.exerciseRepository.findById(id).map(exercise1 -> {
            exercise1.setComment(exercise.getComment());
            return exerciseRepository.save(exercise1);
        });
    }
    @DeleteMapping("/exercises/{id}")
    public void deleteExercise(@PathVariable("id") long id) {
		this.exerciseRepository.deleteById(id);
    }

}
