package org.bitbucket.macko9909.workout.generator;

import org.bitbucket.macko9909.workout.managers.ExerciseManager;
import org.bitbucket.macko9909.workout.model.Exercise;
import org.bitbucket.macko9909.workout.model.MuscleGroup;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class ExerciseGenerator {
    private ExerciseManager exerciseManager;
    private Random random;

    public ExerciseGenerator(ExerciseManager exerciseManager, Random random) {
        this.exerciseManager = exerciseManager;
        this.random = random;
    }

    public Exercise generateByMuscleGroup(MuscleGroup muscleGroup) {
        List<Exercise> byMuscleGroup = exerciseManager.findByMuscleGroup(muscleGroup);
        return byMuscleGroup.get(random.nextInt(byMuscleGroup.size()));
    }

    public Set<Exercise> generateUniqueRandomExercises(MuscleGroup muscleGroup, int numberOfExercises) {
        if (0 > numberOfExercises) {
            throw new IllegalArgumentException("The number cannot be lower than 0");
        }
        if (exerciseManager.countByMuscleGroup(muscleGroup) < numberOfExercises) {
            throw new IllegalArgumentException("The number of exercises is too big");
        }
        Set<Exercise> listOfRandomExercises = new HashSet<>();
        do {
            listOfRandomExercises.add(generateByMuscleGroup(muscleGroup));
        } while (listOfRandomExercises.size() < numberOfExercises);
        return listOfRandomExercises;
    }

}
