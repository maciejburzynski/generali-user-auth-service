package com.generali.userauthservice.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.QueryHint;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Lock(LockModeType.PESSIMISTIC_READ)
    @QueryHints(@QueryHint(value = "3000", name = "jakarta.persistence.lock.timeout"))
    Optional<User> findUserByPassword(String password);

//    @Query(value = "UPDATE USERS SET password= ?2 WHERE username= ?1", nativeQuery = true)
//    @Modifying
//    @Transactional
//    void updateUserByUsername(String username, String password);


//    void updateUserByUsername(String username, User user);
}
