package com.kameleoon.userpost.service;

import com.kameleoon.userpost.exception.ServiceException;

public interface PostVoteService<T> {
    boolean isVoteExist(String login);
    T findVote(String login);
    void saveVote(String login, long postID) throws ServiceException;
    void deleteVote(String login) throws ServiceException;
}
