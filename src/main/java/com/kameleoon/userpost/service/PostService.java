package com.kameleoon.userpost.service;

import com.kameleoon.userpost.model.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findByPage(int page,
                             int size,
                             String filter,
                             String direction);

    PostDto findByUser(String login,
                                     int page,
                                     int size,
                                     String filter,
                                     String direction);
    PostDto findByUserLast(String login);

    PostDto findTopPost();

    PostDto findFlopPost();

    PostDto findRandomPost();

    void savePost(PostDto post);

    void updatePost(long id, PostDto post);

    void deletePost(long id, PostDto post);
    void likePost(long id);
    void dislikePost(long id);
    void deleteLikePost(long id);
    void deleteDislikePost(long id);
}
