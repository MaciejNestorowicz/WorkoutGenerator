package org.bitbucket.macko9909.workout.managers;

import org.bitbucket.macko9909.workout.model.WorkoutJournal;
import org.bitbucket.macko9909.workout.model.User;
import org.bitbucket.macko9909.workout.model.Workout;
import org.bitbucket.macko9909.workout.repos.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserManager {

    private UserRepository userRepository;

    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseGet(null);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public User findUserByEmailAndPassword(String email, String password) {
        return userRepository.checkEmailAndPassword(email, password);
    }

    public void updateWorkoutForUser(String userEmail, Workout workout) {
        User user = userRepository.findUserByEmail(userEmail);
        user.setWorkout(workout);
        userRepository.save(user);
    }

    public void updateWorkoutJournalForUser(String userEmail, WorkoutJournal workoutJournal) {
        User user = userRepository.findUserByEmail(userEmail);
        user.setWorkoutJournal(workoutJournal);
        userRepository.save(user);
    }
}
