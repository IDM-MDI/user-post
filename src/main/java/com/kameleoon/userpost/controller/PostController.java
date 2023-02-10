package com.kameleoon.userpost.controller;

import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.model.ResponsePage;
import com.kameleoon.userpost.model.ResponseStatus;
import com.kameleoon.userpost.service.PostPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostPageService postPageService;
    @GetMapping
    public ResponsePage<PostDto> findByPage(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size,
                                            @RequestParam(defaultValue = "id") String filter,
                                            @RequestParam(defaultValue = "asc") String direction) {
        return postPageService.findByPage(page,size,filter,direction);
    }

    @GetMapping("/{login}")
    public ResponsePage<PostDto> findByUser(@PathVariable String login,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "5") int size,
                                            @RequestParam(defaultValue = "id") String filter,
                                            @RequestParam(defaultValue = "asc") String direction) {
        return postPageService.findByUser(login,page,size,filter,direction);
    }

    @GetMapping("/{login}/last")
    public ResponsePage<PostDto> findByUserLast(@PathVariable String login) {
        return postPageService.findByUserLast(login);
    }

    @GetMapping("/top")
    public ResponsePage<PostDto> findTopPost() {
        return postPageService.findTopPost();
    }

    @GetMapping("/flop")
    public ResponsePage<PostDto> findFlopPost() {
        return postPageService.findFlopPost();
    }

    @GetMapping("/random")
    public ResponsePage<PostDto> findRandomPost() {
        return postPageService.findRandomPost();
    }

    @PostMapping("/{login}")
    public ResponseStatus savePost(@PathVariable String login,
                                   @RequestBody PostDto post) {
        return postPageService.savePost(login, post);
    }

    @PutMapping("/{login}/{id}")
    public ResponseStatus updatePost(@PathVariable String login,
                                     @PathVariable long id,
                                     @RequestBody PostDto post) throws ServiceException {
        return postPageService.updatePost(login,id,post);
    }

    @DeleteMapping("/{login}/{id}")
    public ResponseStatus deletePost(@PathVariable String login,
                                     @PathVariable long id) throws ServiceException {
        return postPageService.deletePost(login,id);
    }

    @PostMapping("/{login}/{id}/like")
    public ResponseStatus likePost(@PathVariable String login,
                                   @PathVariable long id) throws ServiceException {
        return postPageService.likePost(login,id);
    }

    @PostMapping("/{login}/{id}/dislike")
    public ResponseStatus dislikePost(@PathVariable String login,
                                      @PathVariable long id) throws ServiceException {
        return postPageService.dislikePost(login,id);
    }

    @DeleteMapping("/{login}/{id}/like")
    public ResponseStatus deleteLike(@PathVariable String login,
                                     @PathVariable long id) throws ServiceException {
        return postPageService.deleteLikePost(login,id);
    }

    @DeleteMapping("/{login}/{id}/dislike")
    public ResponseStatus deleteDislike(@PathVariable String login,
                                        @PathVariable long id) throws ServiceException {
        return postPageService.deleteDislikePost(login,id);
    }
}
