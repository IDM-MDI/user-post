package com.kameleoon.userpost.service;

import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.model.ResponsePage;
import com.kameleoon.userpost.model.ResponseStatus;

public interface PostPageService {
    ResponsePage<PostDto> findByPage(int page,
                                     int size,
                                     String filter,
                                     String direction);

    ResponsePage<PostDto> findByUser(String login,
                                     int page,
                                     int size,
                                     String filter,
                                     String direction);
    ResponsePage<PostDto> findByUserLast(String login);

    ResponsePage<PostDto> findTopPost();

    ResponsePage<PostDto> findFlopPost();

    ResponsePage<PostDto> findRandomPost();

    ResponseStatus savePost(String login, PostDto post);

    ResponseStatus updatePost(String login, long id, PostDto post) throws ServiceException;

    ResponseStatus deletePost(String login, long id) throws ServiceException;
    ResponseStatus likePost(String login, long id) throws ServiceException;
    ResponseStatus dislikePost(String login, long id) throws ServiceException;
    ResponseStatus deleteLikePost(String login, long id) throws ServiceException;
    ResponseStatus deleteDislikePost(String login, long id) throws ServiceException;
}
