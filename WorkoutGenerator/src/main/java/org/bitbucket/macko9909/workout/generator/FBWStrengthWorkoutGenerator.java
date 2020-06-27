package org.bitbucket.macko9909.workout.generator;

import org.bitbucket.macko9909.workout.model.Exercise;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.bitbucket.macko9909.workout.model.MuscleGroup.*;

@Service
public class FBWStrengthWorkoutGenerator {

    private ExerciseGenerator exerciseGenerator;

    public FBWStrengthWorkoutGenerator(ExerciseGenerator exerciseGenerator) {
        this.exerciseGenerator = exerciseGenerator;
    }

    public List<Exercise> generateExerciseList() {
        List<Exercise> exerciseList = new ArrayList<>();
        exerciseList.addAll(exerciseGenerator.generateUniqueRandomExercises(CHEST, 2));
        exerciseList.addAll(exerciseGenerator.generateUniqueRandomExercises(BACK, 2));
        exerciseList.addAll(exerciseGenerator.generateUniqueRandomExercises(LEGS, 2));
        exerciseList.addAll(exerciseGenerator.generateUniqueRandomExercises(SHOULDERS, 1));
        exerciseList.addAll(exerciseGenerator.generateUniqueRandomExercises(TRICEPS, 1));
        exerciseList.addAll(exerciseGenerator.generateUniqueRandomExercises(BICEPS, 1));
        exerciseList.addAll(exerciseGenerator.generateUniqueRandomExercises(ABS, 1));
        return exerciseList;
    }
}
