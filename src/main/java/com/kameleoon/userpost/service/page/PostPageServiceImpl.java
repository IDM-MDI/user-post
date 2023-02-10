package com.kameleoon.userpost.service.page;

import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.handler.ResponseStatusHandler;
import com.kameleoon.userpost.model.PageInfo;
import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.model.ResponsePage;
import com.kameleoon.userpost.model.ResponseStatus;
import com.kameleoon.userpost.service.PostPageService;
import com.kameleoon.userpost.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostPageServiceImpl implements PostPageService {
    private final PostService service;
    @Override
    public ResponsePage<PostDto> findByPage(int page,
                                            int size,
                                            String filter,
                                            String direction) {
        return ResponsePage.<PostDto>builder()
                .data(service.findByPage(page, size, filter, direction))
                .info(new PageInfo(page,size,filter,direction))
                .status(ResponseStatusHandler.findByPageStatus())
                .build();
    }

    @Override
    public ResponsePage<PostDto> findByUser(String login,
                                            int page,
                                            int size,
                                            String filter,
                                            String direction) {
        return ResponsePage.<PostDto>builder()
                .data(service.findByUser(login, page, size, filter, direction))
                .info(new PageInfo(page,size,filter,direction))
                .status(ResponseStatusHandler.findByPageStatus())
                .build();
    }

    @Override
    public ResponsePage<PostDto> findByUserLast(String login) {
        return ResponsePage.<PostDto>builder()
                .data(service.findByUserLast(login))
                .info(new PageInfo())
                .status(ResponseStatusHandler.findByPageStatus())
                .build();
    }

    @Override
    public ResponsePage<PostDto> findTopPost() {
        return ResponsePage.<PostDto>builder()
                .data(service.findTopPost())
                .info(new PageInfo())
                .status(ResponseStatusHandler.findByPageStatus())
                .build();
    }

    @Override
    public ResponsePage<PostDto> findFlopPost() {
        return ResponsePage.<PostDto>builder()
                .data(service.findFlopPost())
                .info(new PageInfo())
                .status(ResponseStatusHandler.findByPageStatus())
                .build();
    }

    @Override
    public ResponsePage<PostDto> findRandomPost() {
        return ResponsePage.<PostDto>builder()
                .data(List.of(service.findRandomPost()))
                .info(new PageInfo())
                .status(ResponseStatusHandler.findByPageStatus())
                .build();
    }

    @Override
    public ResponseStatus savePost(String login, PostDto post) {
        service.savePost(login,post);
        return ResponseStatusHandler.saveStatus();
    }

    @Override
    public ResponseStatus updatePost(String login, long id, PostDto post) throws ServiceException {
        service.updatePost(login,id,post);
        return ResponseStatusHandler.updateStatus();
    }

    @Override
    public ResponseStatus deletePost(String login, long id) throws ServiceException {
        service.deletePost(login,id);
        return ResponseStatusHandler.deleteStatus();
    }

    @Override
    public ResponseStatus likePost(String login, long id) throws ServiceException {
        service.likePost(login,id);
        return ResponseStatusHandler.likeStatus();
    }

    @Override
    public ResponseStatus dislikePost(String login, long id) throws ServiceException {
        service.dislikePost(login,id);
        return ResponseStatusHandler.dislikeStatus();
    }

    @Override
    public ResponseStatus deleteLikePost(String login, long id) throws ServiceException {
        service.deleteLikePost(login,id);
        return ResponseStatusHandler.deleteStatus();
    }

    @Override
    public ResponseStatus deleteDislikePost(String login, long id) throws ServiceException {
        service.deleteDislikePost(login,id);
        return ResponseStatusHandler.deleteStatus();
    }
}
