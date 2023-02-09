package com.kameleoon.userpost.persistence;

import com.kameleoon.userpost.entity.PostDislike;
import com.kameleoon.userpost.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDislikeRepository extends JpaRepository<PostDislike, Long> {
    boolean existsByUser_Login(String login);
    PostLike findByUser_LoginAndPost_Id(String login, long id);
}
