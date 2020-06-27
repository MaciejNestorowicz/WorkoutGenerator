package org.bitbucket.macko9909.workout.model;

public class UserChangeDTO {

    private AdvancementLevel advancementLevel;
    private WorkoutType workoutType;

    public AdvancementLevel getAdvancementLevel() {
        return advancementLevel;
    }

    public void setAdvancementLevel(AdvancementLevel advancementLevel) {
        this.advancementLevel = advancementLevel;
    }

    public WorkoutType getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(WorkoutType workoutType) {
        this.workoutType = workoutType;
    }
}
