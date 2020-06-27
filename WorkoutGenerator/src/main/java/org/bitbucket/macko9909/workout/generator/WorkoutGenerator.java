package org.bitbucket.macko9909.workout.generator;

import org.bitbucket.macko9909.workout.model.User;
import org.bitbucket.macko9909.workout.model.Workout;
import org.bitbucket.macko9909.workout.model.WorkoutType;
import org.springframework.stereotype.Service;

@Service
public class WorkoutGenerator {

    private FBWStrengthWorkoutGenerator fbwStrengthWorkoutGenerator;
    private FBWEnduranceWorkoutGenerator fbwEnduranceWorkoutGenerator;

    public WorkoutGenerator(FBWStrengthWorkoutGenerator fbwStrengthWorkoutGenerator, FBWEnduranceWorkoutGenerator fbwEnduranceWorkoutGenerator) {
        this.fbwStrengthWorkoutGenerator = fbwStrengthWorkoutGenerator;
        this.fbwEnduranceWorkoutGenerator = fbwEnduranceWorkoutGenerator;
    }

    public Workout generate(User user) {
        if (user.getWorkoutType().equals(WorkoutType.STRENGTH)) {
            return new Workout(fbwStrengthWorkoutGenerator.generateExerciseList());
        } else if (user.getWorkoutType().equals(WorkoutType.ENDURANCE)) {
            return new Workout(fbwEnduranceWorkoutGenerator.generateExerciseList());
        }
        return null;
    }
}
