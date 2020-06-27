package org.bitbucket.macko9909.workout.repos;

import org.bitbucket.macko9909.workout.model.Exercise;
import org.bitbucket.macko9909.workout.model.MuscleGroup;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {

    @Query("SELECT e FROM Exercise e WHERE e.muscleGroup = :searched")
    List<Exercise> findByMuscleGroup(@Param("searched") MuscleGroup searched);

    @Query("SELECT COUNT(e.muscleGroup) FROM Exercise e WHERE e.muscleGroup = :searched")
    int countByMuscleGroup(@Param("searched") MuscleGroup searched);
}
