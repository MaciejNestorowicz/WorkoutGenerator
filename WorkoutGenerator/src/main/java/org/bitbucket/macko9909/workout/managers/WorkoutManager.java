package org.bitbucket.macko9909.workout.managers;

import org.bitbucket.macko9909.workout.model.Workout;
import org.bitbucket.macko9909.workout.repos.WorkoutRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutManager {

    private WorkoutRepository workoutRepository;

    public WorkoutManager(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Workout findById(Long id) {
        return workoutRepository.findById(id).orElseGet(null);
    }

    public void addWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    public void deleteWorkout(Workout workout) {
        workoutRepository.delete(workout);
    }
}
