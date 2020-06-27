package org.bitbucket.macko9909.workout.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class WorkoutUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "workout_unit_exercise_unit",
            joinColumns = @JoinColumn(name = "workout_unit_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_unit_id")
    )
    private List<ExerciseUnit> exerciseUnit;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_journal_id")
    private WorkoutJournal workoutJournal;

    public WorkoutUnit(String name, List<ExerciseUnit> exerciseUnit) {
        this.name = name;
        this.exerciseUnit = exerciseUnit;
    }

    public WorkoutUnit() {
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

    public List<ExerciseUnit> getExerciseUnit() {
        return exerciseUnit;
    }

    public void setExerciseUnit(List<ExerciseUnit> exerciseUnit) {
        this.exerciseUnit = exerciseUnit;
    }

    public WorkoutJournal getWorkoutJournal() {
        return workoutJournal;
    }

    public void setWorkoutJournal(WorkoutJournal workoutJournal) {
        this.workoutJournal = workoutJournal;
    }

    @Override
    public String toString() {
        return "WorkoutUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", exerciseUnit=" + exerciseUnit +
                ", workoutJournal=" + workoutJournal +
                '}';
    }
}
