package com.kameleoon.userpost.service;

import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.model.PostDto;

import java.util.List;

public interface PostService {
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

    void savePost(PostDto post);

    void updatePost(long id, PostDto post);

    void deletePost(long id, PostDto post);
    void likePost(long id) throws ServiceException;
    void dislikePost(long id) throws ServiceException;
    void deleteLikePost(long id) throws ServiceException;
    void deleteDislikePost(long id) throws ServiceException;
}
