package org.bitbucket.macko9909.workout.managers;

import org.bitbucket.macko9909.workout.model.ExerciseUnit;
import org.bitbucket.macko9909.workout.repos.ExerciseUnitRepository;
import org.springframework.stereotype.Service;

@Service
public class ExerciseUnitManager {

    private ExerciseUnitRepository exerciseUnitRepository;

    public ExerciseUnitManager(ExerciseUnitRepository exerciseUnitRepository) {
        this.exerciseUnitRepository = exerciseUnitRepository;
    }

    public ExerciseUnit findById(Long id) {
        return exerciseUnitRepository.findById(id).orElseGet(null);
    }

    public Iterable<ExerciseUnit> findAll() {
        return exerciseUnitRepository.findAll();
    }

    public void save(ExerciseUnit exerciseUnit) {
        exerciseUnitRepository.save(exerciseUnit);
    }

    public void deleteById(Long id) {
        exerciseUnitRepository.deleteById(id);
    }
}
