package org.bitbucket.macko9909.workout.managers;

import org.bitbucket.macko9909.workout.model.*;
import org.bitbucket.macko9909.workout.repos.ExerciseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseManager {

    private ExerciseRepository exerciseRepository;

    public ExerciseManager(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public Exercise findById(Long id) {
        return exerciseRepository.findById(id).orElseGet(null);
    }

    public List<Exercise> findByMuscleGroup(MuscleGroup muscleGroup) {
        return exerciseRepository.findByMuscleGroup(muscleGroup);
    }

    public int countByMuscleGroup(MuscleGroup muscleGroup) {
        return exerciseRepository.countByMuscleGroup(muscleGroup);
    }
}
