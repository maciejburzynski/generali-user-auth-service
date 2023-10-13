package com.generali.userauthservice.user;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

//    @Query(value = "UPDATE USERS SET password= ?2 WHERE username= ?1", nativeQuery = true)
//    @Modifying
//    @Transactional
//    void updateUserByUsername(String username, String password);

    void updateUserByUsername(String username, User user);
}
