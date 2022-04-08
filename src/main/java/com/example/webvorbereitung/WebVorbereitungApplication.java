package com.example.webvorbereitung;

import com.example.webvorbereitung.model.Exercise;
import com.example.webvorbereitung.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WebVorbereitungApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebVorbereitungApplication.class, args);
    }

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Override
    public void run(String... args) throws Exception {
        this.exerciseRepository.saveAll(this.getExercises());
    }

    private List<Exercise> getExercises() {
        return List.of(
                new Exercise("Bizeps-Curls", "Arms", 1, "Take some dumbbells and curl your arm."),

                new Exercise("Benchpress", "Chest", 2, "Lie on a bench and push the weight up vertically with both arms."),

                new Exercise("Squats", "Legs", 3, "Stand up straight, legs shoulder-width apart, and slowly squat down. Keep your back straight and push up from the legs."),

                new Exercise("Back-Rows", "Back", 2, "Bend forward slightly, with a straight back. Take a barbell with both hands and pull it to your belly button.")

        );
    }
}
