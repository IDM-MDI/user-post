package com.kameleoon.userpost.service.page;

import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.model.ResponsePage;
import com.kameleoon.userpost.model.ResponseStatus;
import com.kameleoon.userpost.service.PostPageService;
import org.springframework.stereotype.Service;

@Service
public class PostPageServiceImpl implements PostPageService {
    @Override
    public ResponsePage<PostDto> findByPage(int page, int size, String filter, String direction) {
        return null;
    }

    @Override
    public ResponsePage<PostDto> findByUser(String login, int page, int size, String filter, String direction) {
        return null;
    }

    @Override
    public ResponsePage<PostDto> findByUserLast(String login) {
        return null;
    }

    @Override
    public ResponsePage<PostDto> findTopPost() {
        return null;
    }

    @Override
    public ResponsePage<PostDto> findFlopPost() {
        return null;
    }

    @Override
    public ResponsePage<PostDto> findRandomPost() {
        return null;
    }

    @Override
    public ResponseStatus savePost(PostDto post) {
        return null;
    }

    @Override
    public ResponseStatus updatePost(long id, PostDto post) {
        return null;
    }

    @Override
    public ResponseStatus deletePost(long id, PostDto post) {
        return null;
    }

    @Override
    public ResponseStatus likePost(long id) {
        return null;
    }

    @Override
    public ResponseStatus dislikePost(long id) {
        return null;
    }

    @Override
    public ResponseStatus deleteLikePost(long id) {
        return null;
    }

    @Override
    public ResponseStatus deleteDislikePost(long id) {
        return null;
    }
}
