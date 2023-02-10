package com.kameleoon.userpost.persistence;

import com.kameleoon.userpost.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByLogin(String login);
    Optional<User> findUserByLogin(String login);
}
