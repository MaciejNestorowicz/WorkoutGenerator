package org.bitbucket.macko9909.workout.managers;

import org.bitbucket.macko9909.workout.model.WorkoutJournal;
import org.bitbucket.macko9909.workout.model.WorkoutUnit;
import org.bitbucket.macko9909.workout.repos.WorkoutUnitRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutUnitManager {

    private WorkoutUnitRepository workoutUnitRepository;

    public WorkoutUnitManager(WorkoutUnitRepository workoutUnitRepository) {
        this.workoutUnitRepository = workoutUnitRepository;
    }

    public void addWorkoutUnit(WorkoutUnit workoutUnit){
        workoutUnitRepository.save(workoutUnit);
    }

    public WorkoutUnit findByName(String name) {
        return workoutUnitRepository.findByName(name);
    }

    public WorkoutUnit findById(Long id) {
        return workoutUnitRepository.findById(id).get();
    }

    public void updateWorkoutJournalForWorkoutUnit(Long id, WorkoutJournal workoutJournal) {
        WorkoutUnit workoutUnit = workoutUnitRepository.findById(id).orElseGet(null);
        workoutUnit.setWorkoutJournal(workoutJournal);
        workoutUnitRepository.save(workoutUnit);
    }

    public WorkoutUnit findByNameForWorkoutJournal(String name, WorkoutJournal workoutJournal) {
        return workoutUnitRepository.findByNameForWorkoutJournal(name, workoutJournal);
    }

    public void deleteById(Long id) {
        workoutUnitRepository.deleteById(id);
    }

}
