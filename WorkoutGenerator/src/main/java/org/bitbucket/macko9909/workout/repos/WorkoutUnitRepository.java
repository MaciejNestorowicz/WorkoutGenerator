package org.bitbucket.macko9909.workout.repos;

import org.bitbucket.macko9909.workout.model.WorkoutJournal;
import org.bitbucket.macko9909.workout.model.WorkoutUnit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface WorkoutUnitRepository extends CrudRepository<WorkoutUnit, Long> {

    @Query("SELECT w FROM WorkoutUnit w WHERE w.name = :searched AND w.workoutJournal = :searchedJournal")
    WorkoutUnit findByNameForWorkoutJournal(@Param("searched") String name, @Param("searchedJournal")WorkoutJournal workoutJournal);

    @Query("SELECT w FROM WorkoutUnit w WHERE w.name = :searched")
    WorkoutUnit findByName(@Param("searched")String name);
}
