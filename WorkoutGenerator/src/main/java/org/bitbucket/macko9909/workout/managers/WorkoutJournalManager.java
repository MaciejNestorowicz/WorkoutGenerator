package org.bitbucket.macko9909.workout.managers;

import org.bitbucket.macko9909.workout.model.WorkoutJournal;
import org.bitbucket.macko9909.workout.repos.WorkoutJournalRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutJournalManager {

    private WorkoutJournalRepository workoutJournalRepository;

    public WorkoutJournalManager(WorkoutJournalRepository workoutJournalRepository) {
        this.workoutJournalRepository = workoutJournalRepository;
    }

    public WorkoutJournal findById(Long id) {
        return workoutJournalRepository.findById(id).orElseGet(null);
    }

    public void addWorkoutJournal(WorkoutJournal workoutJournal) {
        workoutJournalRepository.save(workoutJournal);
    }
}
