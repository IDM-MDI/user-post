package com.kameleoon.userpost.service.impl;

import com.kameleoon.userpost.entity.Post;
import com.kameleoon.userpost.entity.PostDislike;
import com.kameleoon.userpost.entity.User;
import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.persistence.PostDislikeRepository;
import com.kameleoon.userpost.service.PostVoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostDislikeService implements PostVoteService<PostDislike> {
    private final PostDislikeRepository repository;
    @Override
    public boolean isVoteExist(String login) {
        return repository.existsByUser_Login(login);
    }

    @Override
    public PostDislike findVote(String login, long id) {
        return repository.findByUser_LoginAndPost_Id(login, id);
    }

    @Override
    public void saveVote(User user, Post post) throws ServiceException {
        if(isVoteExist(user.getLogin())) {
            log.error("");
            throw new ServiceException();
        }

        repository.save(
                PostDislike.builder()
                        .user(user)
                        .post(post)
                        .build()
        );
        log.info("");
    }

    @Override
    public void deleteVote(User user, Post post) throws ServiceException {
        if(!isVoteExist(user.getLogin())) {
            log.error("");
            throw new ServiceException();
        }
        repository.delete(findVote(user.getLogin(), post.getId()));
        log.info("");
    }
}
