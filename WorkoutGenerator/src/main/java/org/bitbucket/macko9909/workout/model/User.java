package org.bitbucket.macko9909.workout.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id", referencedColumnName = "id")
    private Workout workout;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_journal_id", referencedColumnName = "id")
    private WorkoutJournal workoutJournal;

    private String email;
    private String fullName;
    private String password;
    private AdvancementLevel advancementLevel;
    private WorkoutType workoutType;

    public User(String email, String fullName, String password, AdvancementLevel advancementLevel, WorkoutType workoutType) {
        this.email = email;
        this.fullName = fullName;
        this.advancementLevel = advancementLevel;
        this.workoutType = workoutType;
        this.password = password;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public Workout getWorkout() {
        return workout;
    }

    public void setWorkout(Workout workout) {
        this.workout = workout;
    }

    public WorkoutJournal getWorkoutJournal() {
        return workoutJournal;
    }

    public void setWorkoutJournal(WorkoutJournal workoutJournal) {
        this.workoutJournal = workoutJournal;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", workout=" + workout +
                ", workoutJournal=" + workoutJournal +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", password='" + password + '\'' +
                ", advancementLevel=" + advancementLevel +
                ", workoutType=" + workoutType +
                '}';
    }
}
