package org.bitbucket.macko9909.workout.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private MuscleGroup muscleGroup;
    private ExerciseType type;

    @ManyToMany(mappedBy = "exercises", fetch = FetchType.LAZY)
    private List<Workout> workout;

    public Exercise(String name, MuscleGroup muscleGroup, ExerciseType type) {
        this.name = name;
        this.muscleGroup = muscleGroup;
        this.type = type;
    }

    public Exercise() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MuscleGroup getMuscleGroup() {
        return muscleGroup;
    }

    public void setMuscleGroup(MuscleGroup muscleGroup) {
        this.muscleGroup = muscleGroup;
    }

    public ExerciseType getType() {
        return type;
    }

    public void setType(ExerciseType type) {
        this.type = type;
    }

    public List<Workout> getWorkout() {
        return workout;
    }

    public void setWorkout(List<Workout> workout) {
        this.workout = workout;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", muscleGroup='" + muscleGroup + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
