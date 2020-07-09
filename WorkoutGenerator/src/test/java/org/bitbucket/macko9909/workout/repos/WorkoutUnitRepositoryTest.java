package org.bitbucket.macko9909.workout.repos;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.bitbucket.macko9909.workout.model.ExerciseUnit;
import org.bitbucket.macko9909.workout.model.WorkoutJournal;
import org.bitbucket.macko9909.workout.model.WorkoutUnit;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class WorkoutUnitRepositoryTest {

    @Autowired
    private WorkoutUnitRepository workoutUnitRepository;

    @Test
    public void shouldReturnWorkoutUnitByNameAndWorkoutJournal() {
        List<ExerciseUnit> list = new ArrayList<>();
        WorkoutUnit workoutUnitOne = new WorkoutUnit("One", list);
        WorkoutUnit workoutUnitTwo = new WorkoutUnit("Two", list);

        WorkoutJournal workoutJournalMock = mock(WorkoutJournal.class);
        workoutUnitOne.setWorkoutJournal(workoutJournalMock);
        workoutUnitTwo.setWorkoutJournal(workoutJournalMock);

        workoutUnitRepository.save(workoutUnitOne);
        workoutUnitRepository.save(workoutUnitTwo);

        WorkoutUnit byNameForWorkoutJournal = workoutUnitRepository.findByNameForWorkoutJournal(workoutUnitOne.getName(), workoutJournalMock);
        assertEquals(workoutUnitOne, byNameForWorkoutJournal);
    }

    @Test
    public void shouldReturnWorkoutUnitByName() {
        List<ExerciseUnit> list = new ArrayList<>();
        WorkoutUnit workoutUnitOne = new WorkoutUnit("One", list);
        WorkoutUnit workoutUnitTwo = new WorkoutUnit("Two", list);

        workoutUnitRepository.save(workoutUnitOne);
        workoutUnitRepository.save(workoutUnitTwo);

        WorkoutUnit byName = workoutUnitRepository.findByName(workoutUnitOne.getName());
        assertEquals(workoutUnitOne, byName);
    }
}