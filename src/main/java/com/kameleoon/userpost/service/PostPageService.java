package com.kameleoon.userpost.service;

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

    ResponseStatus savePost(PostDto post);

    ResponseStatus updatePost(long id, PostDto post);

    ResponseStatus deletePost(long id, PostDto post);
    ResponseStatus likePost(long id);
    ResponseStatus dislikePost(long id);
    ResponseStatus deleteLikePost(long id);
    ResponseStatus deleteDislikePost(long id);
}
