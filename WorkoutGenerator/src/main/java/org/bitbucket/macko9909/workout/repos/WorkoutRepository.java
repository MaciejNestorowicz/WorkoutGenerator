package org.bitbucket.macko9909.workout.repos;

import org.bitbucket.macko9909.workout.model.Workout;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {

}
