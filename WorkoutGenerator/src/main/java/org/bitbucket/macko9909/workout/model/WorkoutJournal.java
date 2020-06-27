package org.bitbucket.macko9909.workout.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class WorkoutJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "workoutJournal")
    private User user;

    @OneToMany(mappedBy = "workoutJournal")
    private List<WorkoutUnit> workoutUnit;

    public WorkoutJournal(List<WorkoutUnit> workoutUnits) {
        this.workoutUnit = workoutUnits;
    }

    public WorkoutJournal() {
    }

    public Long getId() {
        return id;
    }

    public List<WorkoutUnit> getWorkoutUnit() {
        return workoutUnit;
    }

    public void setWorkoutUnit(List<WorkoutUnit> workoutUnit) {
        this.workoutUnit = workoutUnit;
    }
}
