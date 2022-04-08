package com.example.webvorbereitung.model;
import javax.persistence.*;
@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "bodypart")
    private String bodypart;
    @Column(name = "difficulty")
    private int difficulty;
    @Column(name = "comment")
    private String comment;

    public Exercise(String title, String bodypart, int difficulty, String comment) {
        this.title = title;
        this.bodypart = bodypart;
        this.difficulty = difficulty;
        this.comment = comment;
    }

    public Exercise() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBodypart() {
        return bodypart;
    }

    public void setBodypart(String bodypart) {
        this.bodypart = bodypart;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
