package com.kameleoon.userpost.service.impl;

import com.kameleoon.userpost.entity.PostLike;
import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.persistence.PostLikeRepository;
import com.kameleoon.userpost.persistence.PostRepository;
import com.kameleoon.userpost.persistence.UserRepository;
import com.kameleoon.userpost.service.PostVoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostLikeService implements PostVoteService<PostLike> {
    private final PostLikeRepository repository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Override
    public boolean isVoteExist(String login) {
        return repository.existsByUser_Login(login);
    }

    @Override
    public PostLike findVote(String login) {
        return repository.findByUser_Login(login);
    }

    @Override
    public void saveVote(String login, long postID) throws ServiceException {
        if(isVoteExist(login)) {
            log.error("");
            throw new ServiceException();
        }

        repository.save(
                PostLike.builder()
                        .user(userRepository.findUserByLogin(login)
                                .orElseThrow()
                        )
                        .post(postRepository.findById(postID)
                                .orElseThrow()
                        )
                        .build()
        );
    }

    @Override
    public void deleteVote(String login) throws ServiceException {
        if(!isVoteExist(login)) {
            log.error("");
            throw new ServiceException();
        }
        repository.delete(findVote(login));
    }
}
