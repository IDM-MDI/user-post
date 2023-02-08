package com.kameleoon.userpost.persistence;

import com.kameleoon.userpost.entity.PostDislike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDislikeRepository extends JpaRepository<PostDislike, Long> {
    boolean existsByUser_Login(String login);
    PostDislike findByUser_Login(String login);
}
