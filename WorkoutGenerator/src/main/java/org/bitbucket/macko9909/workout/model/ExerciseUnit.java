package org.bitbucket.macko9909.workout.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ExerciseUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int sets;
    private int reps;
    private int weight;

    @ManyToMany(mappedBy = "exerciseUnit", fetch = FetchType.LAZY)
    private List<WorkoutUnit> workoutUnit;

    public ExerciseUnit(String name, int sets, int reps, int weight, List<WorkoutUnit> workoutUnit) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.workoutUnit = workoutUnit;
    }

    public ExerciseUnit() {
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

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<WorkoutUnit> getWorkoutUnit() {
        return workoutUnit;
    }

    public void setWorkoutUnit(List<WorkoutUnit> workoutUnit) {
        this.workoutUnit = workoutUnit;
    }

    @Override
    public String toString() {
        return "ExerciseUnit{" +
                "name='" + name + '\'' +
                ", sets=" + sets +
                ", reps=" + reps +
                ", weight=" + weight +
                '}';
    }
}
