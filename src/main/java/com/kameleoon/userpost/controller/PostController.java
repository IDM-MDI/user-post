package com.kameleoon.userpost.controller;

import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.model.ResponsePage;
import com.kameleoon.userpost.model.ResponseStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    @GetMapping
    public ResponsePage<PostDto> findByPage(int page,
                                            int size,
                                            String filter,
                                            String direction) {
        return null;
    }

    @GetMapping("/{login}")
    public ResponsePage<PostDto> findByUser(@PathVariable String login,
                                            int page,
                                            int size,
                                            String filter,
                                            String direction) {
        return null;
    }

    @GetMapping("/{login}/last")
    public ResponsePage<PostDto> findByUserLast(@PathVariable String login) {
        return null;
    }

    @GetMapping("/top")
    public ResponsePage<PostDto> findTopPost() {
        return null;
    }

    @GetMapping("/flop")
    public ResponsePage<PostDto> findFlopPost() {
        return null;
    }

    @GetMapping("/random")
    public ResponsePage<PostDto> findRandomPost() {
        return null;
    }

    @PostMapping
    public ResponseStatus savePost(@RequestBody PostDto post) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseStatus updatePost(@PathVariable long id, @RequestBody PostDto post) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseStatus deletePost(@PathVariable long id, @RequestBody PostDto post) {
        return null;
    }

    @PostMapping("/{id}/like")
    public ResponseStatus likePost(@PathVariable String id) {
        return null;
    }

    @PostMapping("/{id}/dislike")
    public ResponseStatus dislikePost(@PathVariable String id) {
        return null;
    }

    @DeleteMapping("/{id}/like")
    public ResponseStatus deleteLike(@PathVariable String id) {
        return null;
    }

    @DeleteMapping("/{id}/dislike")
    public ResponseStatus deleteDislike(@PathVariable String id) {
        return null;
    }
}
