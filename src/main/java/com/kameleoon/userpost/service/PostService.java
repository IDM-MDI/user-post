package com.kameleoon.userpost.service;

import com.kameleoon.userpost.entity.Post;
import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.model.UserDto;

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

    void savePost(PostDto post);

    void updatePost(long id, PostDto post);

    void deletePost(long id, UserDto user) throws ServiceException;
    void likePost(long id, UserDto user) throws ServiceException;
    void dislikePost(long id, UserDto user) throws ServiceException;
    void deleteLikePost(long id, UserDto user) throws ServiceException;
    void deleteDislikePost(long id, UserDto user) throws ServiceException;
}
