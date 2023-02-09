package com.kameleoon.userpost.service.impl;

import com.kameleoon.userpost.entity.PostDislike;
import com.kameleoon.userpost.entity.PostLike;
import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.service.PostService;
import com.kameleoon.userpost.service.PostVoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostVoteService<PostLike> postLikeService;
    private final PostVoteService<PostDislike> postDislikeService;

    @Override
    public List<PostDto> findByPage(int page, int size, String filter, String direction) {
        return null;
    }

    @Override
    public PostDto findByUser(String login, int page, int size, String filter, String direction) {
        return null;
    }

    @Override
    public PostDto findByUserLast(String login) {
        return null;
    }

    @Override
    public PostDto findTopPost() {
        return null;
    }

    @Override
    public PostDto findFlopPost() {
        return null;
    }

    @Override
    public PostDto findRandomPost() {
        return null;
    }

    @Override
    public void savePost(PostDto post) {

    }

    @Override
    public void updatePost(long id, PostDto post) {

    }

    @Override
    public void deletePost(long id, PostDto post) {

    }

    @Override
    public void likePost(long id) throws ServiceException {
        postLikeService.saveVote(null,null);
    }

    @Override
    public void dislikePost(long id) throws ServiceException {
        postDislikeService.saveVote(null,null);
    }

    @Override
    public void deleteLikePost(long id) throws ServiceException {
        postLikeService.deleteVote(null,null);
    }

    @Override
    public void deleteDislikePost(long id) throws ServiceException {
        postDislikeService.deleteVote(null,null);
    }
}
