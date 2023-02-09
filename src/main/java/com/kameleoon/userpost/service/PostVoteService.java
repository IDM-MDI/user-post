package com.kameleoon.userpost.service;

import com.kameleoon.userpost.entity.Post;
import com.kameleoon.userpost.entity.User;
import com.kameleoon.userpost.exception.ServiceException;

public interface PostVoteService<T> {
    boolean isVoteExist(String login);
    T findVote(String login);
    void saveVote(User user, Post post) throws ServiceException;
    void deleteVote(String login) throws ServiceException;
}
