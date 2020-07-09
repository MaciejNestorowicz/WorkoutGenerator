package org.bitbucket.macko9909.workout.generator;

import org.bitbucket.macko9909.workout.managers.ExerciseManager;
import org.bitbucket.macko9909.workout.model.Exercise;
import org.bitbucket.macko9909.workout.model.ExerciseType;
import org.bitbucket.macko9909.workout.model.MuscleGroup;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExerciseGeneratorTest {

    @Test
    public void shouldThrowExceptionWhenNumberOfExercisesIsTooBig() {
        ExerciseManager exerciseManagerMock = mock(ExerciseManager.class);
        Random randomMock = mock(Random.class);
        when(exerciseManagerMock.countByMuscleGroup(MuscleGroup.LEGS)).thenReturn(5);
        ExerciseGenerator exerciseGenerator = new ExerciseGenerator(exerciseManagerMock, randomMock);

        Exception exception = assertThrows(IllegalArgumentException.class, ()-> exerciseGenerator.generateUniqueRandomExercises(MuscleGroup.LEGS, 6));
        assertEquals("The number of exercises is too big", exception.getMessage());
    }

    @Test
    public void shouldReturnRandomExercisesForMuscleGroup() {
        ExerciseManager exerciseManagerMock = mock(ExerciseManager.class);
        Random randomMock = mock(Random.class);
        when(exerciseManagerMock.countByMuscleGroup(MuscleGroup.LEGS)).thenReturn(2);
        List<Exercise> listOfLegsExercises = new ArrayList<>();
        listOfLegsExercises.add(new Exercise("Squats", MuscleGroup.LEGS, ExerciseType.MULTI_JOINT));
        listOfLegsExercises.add(new Exercise("Leg Extensions", MuscleGroup.LEGS, ExerciseType.MULTI_JOINT));
        listOfLegsExercises.add(new Exercise("Lunges", MuscleGroup.LEGS, ExerciseType.MULTI_JOINT));
        when(randomMock.nextInt(listOfLegsExercises.size())).thenReturn(0).thenReturn(0).thenReturn(1);
        when(exerciseManagerMock.findByMuscleGroup(MuscleGroup.LEGS)).thenReturn(listOfLegsExercises);

        ExerciseGenerator exerciseGenerator = new ExerciseGenerator(exerciseManagerMock, randomMock);
        Set<Exercise> exercises = exerciseGenerator.generateUniqueRandomExercises(MuscleGroup.LEGS, 2);
        Set<Exercise> expected = new HashSet<>();
        expected.add(listOfLegsExercises.get(0));
        expected.add(listOfLegsExercises.get(1));

        assertEquals(expected, exercises);
        assertEquals(2, exercises.size());

        //without creating outcome HashSet
        assertTrue(exercises.contains(listOfLegsExercises.get(0)));
        assertTrue(exercises.contains(listOfLegsExercises.get(1)));
    }

    @Test
    public void shouldThrowExceptionForNegativeValue(){
        ExerciseManager exerciseManagerMock = mock(ExerciseManager.class);
        Random randomMock = mock(Random.class);
        when(exerciseManagerMock.countByMuscleGroup(MuscleGroup.LEGS)).thenReturn(2);
        List<Exercise> listOfLegsExercises = new ArrayList<>();
        listOfLegsExercises.add(new Exercise("Squats", MuscleGroup.LEGS, ExerciseType.MULTI_JOINT));
        listOfLegsExercises.add(new Exercise("Leg Extensions", MuscleGroup.LEGS, ExerciseType.MULTI_JOINT));
        listOfLegsExercises.add(new Exercise("Lunges", MuscleGroup.LEGS, ExerciseType.MULTI_JOINT));
        when(randomMock.nextInt(listOfLegsExercises.size())).thenReturn(0).thenReturn(0).thenReturn(1);
        when(exerciseManagerMock.findByMuscleGroup(MuscleGroup.LEGS)).thenReturn(listOfLegsExercises);
        ExerciseGenerator exerciseGenerator = new ExerciseGenerator(exerciseManagerMock, randomMock);

        Exception exception = assertThrows(IllegalArgumentException.class, ()-> exerciseGenerator.generateUniqueRandomExercises(MuscleGroup.LEGS, -1));
    }
}