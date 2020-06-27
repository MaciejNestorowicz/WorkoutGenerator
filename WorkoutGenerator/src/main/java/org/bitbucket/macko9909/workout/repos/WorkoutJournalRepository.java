package org.bitbucket.macko9909.workout.repos;

import org.bitbucket.macko9909.workout.model.WorkoutJournal;
import org.springframework.data.repository.CrudRepository;

public interface WorkoutJournalRepository extends CrudRepository<WorkoutJournal, Long> {
}
