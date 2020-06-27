package org.bitbucket.macko9909.workout.controller;

import org.bitbucket.macko9909.workout.generator.WorkoutGenerator;
import org.bitbucket.macko9909.workout.managers.UserManager;
import org.bitbucket.macko9909.workout.managers.WorkoutManager;
import org.bitbucket.macko9909.workout.model.User;
import org.bitbucket.macko9909.workout.model.UserChangeDTO;
import org.bitbucket.macko9909.workout.model.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
public class UserPageController {

    @Autowired
    UserManager userManager;

    @Autowired
    WorkoutManager workoutManager;

    @Autowired
    private WorkoutGenerator workoutGenerator;

    @GetMapping("/user_page")
    public String greetUser(@CookieValue(value = "user") String cookieUser, Model model){
        User user = userManager.findByEmail(cookieUser);
        Workout workout = user.getWorkout();
        if (workout == null) {
            workout = workoutGenerator.generate(user);
            userManager.updateWorkoutForUser(user.getEmail(), workout);
        }

        model.addAttribute("user", user);
        model.addAttribute("workout", workout);
        return "user_page";
    }

    @GetMapping("/generate_workout")
    public String generateWorkout(UserChangeDTO userChangeDTO) {
        return "generate_workout";
    }

    @PostMapping("/update_user")
    public void updateUser(@CookieValue(value = "user") String cookieUser, UserChangeDTO userChangeDTO, HttpServletResponse response) {
        User user = userManager.findByEmail(cookieUser);
        Workout oldWorkout = user.getWorkout();
        user.setAdvancementLevel(userChangeDTO.getAdvancementLevel());
        user.setWorkoutType(userChangeDTO.getWorkoutType());
        Workout workout = workoutGenerator.generate(user);
        userManager.updateWorkoutForUser(user.getEmail(), workout);
        oldWorkout.getExercises().clear();
        workoutManager.deleteWorkout(oldWorkout);
        try {
            response.sendRedirect("user_page");
        } catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}
