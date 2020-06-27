package org.bitbucket.macko9909.workout.model;

public class ExerciseUnitDTO {

    private String workoutUnit;
    private String name;
    private int sets;
    private int reps;
    private int weight;

    public String getName() {
        return name;
    }

    public String getWorkoutUnit() {
        return workoutUnit;
    }

    public void setWorkoutUnit(String workoutUnit) {
        this.workoutUnit = workoutUnit;
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
}
