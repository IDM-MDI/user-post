package com.kameleoon.userpost.persistence;

import com.kameleoon.userpost.entity.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    boolean existsByUser_Login(String login);
    PostLike findByUser_LoginAndPost_Id(String login, long id);
}
