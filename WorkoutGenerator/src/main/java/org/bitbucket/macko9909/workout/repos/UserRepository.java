package org.bitbucket.macko9909.workout.repos;

import org.bitbucket.macko9909.workout.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = :searched")
    User findUserByEmail(@Param("searched") String searched);

    @Query("SELECT u FROM User u WHERE u.email = :searchedEmail AND u.password = :searchedPassword")
    User checkEmailAndPassword(@Param("searchedEmail")String email, @Param("searchedPassword") String password);
}
