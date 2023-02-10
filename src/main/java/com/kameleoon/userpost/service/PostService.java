package com.kameleoon.userpost.service;

import com.kameleoon.userpost.entity.Post;
import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.model.PostDto;

import java.util.List;

public interface PostService {
    Post findByID(long id) throws ServiceException;
    List<PostDto> findByPage(int page,
                             int size,
                             String filter,
                             String direction);

    List<PostDto> findByUser(String login,
                             int page,
                             int size,
                             String filter,
                             String direction);
    List<PostDto> findByUserLast(String login);

    List<PostDto> findTopPost();

    List<PostDto> findFlopPost();

    PostDto findRandomPost();

    void savePost(String login, PostDto post);

    void updatePost(String login, long id, PostDto post) throws ServiceException;

    void deletePost(String login, long id) throws ServiceException;
    void likePost(String id, long user) throws ServiceException;
    void dislikePost(String id, long user) throws ServiceException;
    void deleteLikePost(String id, long user) throws ServiceException;
    void deleteDislikePost(String id, long user) throws ServiceException;
}
