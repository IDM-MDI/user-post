package com.kameleoon.userpost.controller;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostPageService postPageService;
    @GetMapping
    public ResponsePage<PostDto> findByPage(int page,
                                            int size,
                                            String filter,
                                            String direction) {
        return postPageService.findByPage(page,size,filter,direction);
    }

    @GetMapping("/{login}")
    public ResponsePage<PostDto> findByUser(@PathVariable String login,
                                            int page,
                                            int size,
                                            String filter,
                                            String direction) {
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

    @PostMapping
    public ResponseStatus savePost(@RequestBody PostDto post) {
        return postPageService.savePost(post);
    }

    @PutMapping("/{id}")
    public ResponseStatus updatePost(@PathVariable long id, @RequestBody PostDto post) {
        return postPageService.updatePost(id,post);
    }

    @DeleteMapping("/{id}")
    public ResponseStatus deletePost(@PathVariable long id, @RequestBody PostDto post) {
        return postPageService.deletePost(id,post);
    }

    @PostMapping("/{id}/like")
    public ResponseStatus likePost(@PathVariable long id) {
        return postPageService.likePost(id);
    }

    @PostMapping("/{id}/dislike")
    public ResponseStatus dislikePost(@PathVariable long id) {
        return postPageService.dislikePost(id);
    }

    @DeleteMapping("/{id}/like")
    public ResponseStatus deleteLike(@PathVariable long id) {
        return postPageService.deleteLikePost(id);
    }

    @DeleteMapping("/{id}/dislike")
    public ResponseStatus deleteDislike(@PathVariable long id) {
        return postPageService.deleteDislikePost(id);
    }
}
