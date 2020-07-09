package org.bitbucket.macko9909.workout.repos;

import org.bitbucket.macko9909.workout.model.Exercise;
import org.bitbucket.macko9909.workout.model.MuscleGroup;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class ExerciseRepositoryTest {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Test
    public void shouldReturnExercisesByMuscleGroup(){
        List<Exercise> byMuscleGroup = exerciseRepository.findByMuscleGroup(MuscleGroup.ABS);

        assertEquals(6, byMuscleGroup.size());
        for (Exercise exercise : byMuscleGroup) {
            assertEquals(MuscleGroup.ABS, exercise.getMuscleGroup());
        }
    }

    @Test
    public void shouldReturnNumberOfExercisesByMuscleGroup() {
        int byMuscleGroup = exerciseRepository.countByMuscleGroup(MuscleGroup.ABS);

        assertEquals(6, byMuscleGroup);
    }
}