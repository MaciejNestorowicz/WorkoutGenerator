package org.bitbucket.macko9909.workout.controller;

import org.bitbucket.macko9909.workout.model.ExerciseUnit;
import org.bitbucket.macko9909.workout.model.WorkoutJournal;
import org.bitbucket.macko9909.workout.model.WorkoutUnit;
import org.bitbucket.macko9909.workout.model.ExerciseUnitDTO;
import org.bitbucket.macko9909.workout.model.WorkoutUnitDTO;
import org.bitbucket.macko9909.workout.managers.ExerciseUnitManager;
import org.bitbucket.macko9909.workout.managers.WorkoutJournalManager;
import org.bitbucket.macko9909.workout.managers.WorkoutUnitManager;
import org.bitbucket.macko9909.workout.managers.UserManager;
import org.bitbucket.macko9909.workout.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainingJournal {

    @Autowired
    private UserManager userManager;

    @Autowired
    private WorkoutJournalManager workoutJournalManager;

    @Autowired
    private WorkoutUnitManager workoutUnitManager;

    @Autowired
    private ExerciseUnitManager exerciseUnitManager;

    @GetMapping("/training_journal")
    public String trainingJournal(@CookieValue(value = "user") String cookieUser, Model model, WorkoutUnitDTO workoutUnitDTO, ExerciseUnitDTO exerciseUnitDTO) {
        User user = userManager.findByEmail(cookieUser);
        if (user.getWorkoutJournal() == null) {
            List<WorkoutUnit> workoutUnits = new ArrayList<>();
            WorkoutJournal workoutJournal = new WorkoutJournal(workoutUnits);
            workoutJournalManager.addWorkoutJournal(workoutJournal);
            userManager.updateWorkoutJournalForUser(user.getEmail(), workoutJournal);
        }
        model.addAttribute("data", exerciseUnitManager.findAll());
        WorkoutJournal workoutJournal = user.getWorkoutJournal();
        model.addAttribute("workoutJournal", workoutJournal);
        return "training_journal";
    }

    @PostMapping("/add_workout_unit")
    public String addWorkoutUnit(@CookieValue(value = "user") String cookieUser, WorkoutUnitDTO workoutUnitDTO, BindingResult result, Model model) {
        User user = userManager.findByEmail(cookieUser);
        WorkoutJournal workoutJournal = user.getWorkoutJournal();
        model.addAttribute("workoutJournal", workoutJournal);

        if (workoutUnitManager.findByNameForWorkoutJournal(workoutUnitDTO.getName(), user.getWorkoutJournal()) != null) {
            result.rejectValue("name", null, "There is already a workout with that name");
        }
        if (result.hasErrors()) {
            return "training_journal";
        }
        List<ExerciseUnit> list = new ArrayList<>();
        WorkoutUnit workoutUnit = new WorkoutUnit(workoutUnitDTO.getName(), list);
        workoutUnitManager.addWorkoutUnit(workoutUnit);
        workoutUnitManager.updateWorkoutJournalForWorkoutUnit(workoutUnit.getId(), user.getWorkoutJournal());

        return "redirect:training_journal";
    }

    @GetMapping("/deleteWorkoutUnit/{id}")
    public String deleteWorkoutInit(@PathVariable Long id) {
        workoutUnitManager.deleteById(id);
        return "redirect:/training_journal";
    }

    @PostMapping("/save/{id}")
    public String saveExerciseUnit(@RequestBody ExerciseUnit exerciseUnit, @PathVariable Long id) {
        WorkoutUnit byId = workoutUnitManager.findById(id);
        byId.getExerciseUnit().add(exerciseUnit);
        exerciseUnitManager.save(exerciseUnit);

        return "redirect:/training_journal";
    }

    @GetMapping("/delete/{exerciseId}/{workoutUnitId}")
    public String deleteExerciseUnit(@PathVariable Long exerciseId, @PathVariable Long workoutUnitId) {
        WorkoutUnit byId = workoutUnitManager.findById(workoutUnitId);
        ExerciseUnit exerciseUnit = exerciseUnitManager.findById(exerciseId);
        byId.getExerciseUnit().remove(exerciseUnit);
        exerciseUnitManager.deleteById(exerciseId);
        return "redirect:/training_journal";
    }
}
