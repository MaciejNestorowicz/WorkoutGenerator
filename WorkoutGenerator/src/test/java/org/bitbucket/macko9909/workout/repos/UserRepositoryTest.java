package org.bitbucket.macko9909.workout.repos;

import static org.junit.jupiter.api.Assertions.*;

import org.bitbucket.macko9909.workout.model.AdvancementLevel;
import org.bitbucket.macko9909.workout.model.User;
import org.bitbucket.macko9909.workout.model.WorkoutType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldReturnUserByEmail() {
        User userOne = new User("gmail", "nameOne", "passOne", AdvancementLevel.BEGINNER, WorkoutType.STRENGTH);
        User userTwo = new User("wp", "nameTwo", "passTwo", AdvancementLevel.ADVANCED, WorkoutType.ENDURANCE);
        userRepository.save(userOne);
        userRepository.save(userTwo);

        User gmail = userRepository.findUserByEmail("gmail");
        assertEquals(userOne, gmail);
    }

    @Test
    public void shouldReturnUserIfEmailAndPasswordAreMatching() {
        User userOne = new User("gmail", "nameOne", "passOne", AdvancementLevel.BEGINNER, WorkoutType.STRENGTH);
        User userTwo = new User("wp", "nameTwo", "passTwo", AdvancementLevel.ADVANCED, WorkoutType.ENDURANCE);
        userRepository.save(userOne);
        userRepository.save(userTwo);

        User user = userRepository.checkEmailAndPassword(userOne.getEmail(), userOne.getPassword());
        assertEquals(user, userOne);
    }
}