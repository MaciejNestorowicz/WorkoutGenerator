package org.bitbucket.macko9909.workout.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "workout_exercise",
            joinColumns = @JoinColumn(name = "workout_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;

    public Workout(List<Exercise> exercises) {
        this.exercises = Collections.unmodifiableList(exercises);
    }

    public Workout() {
    }

    public Long getId() {
        return id;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", exercises=" + exercises +
                '}';
    }
}
