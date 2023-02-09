package com.kameleoon.userpost.service.impl;

import com.kameleoon.userpost.entity.Post;
import com.kameleoon.userpost.entity.PostDislike;
import com.kameleoon.userpost.entity.PostLike;
import com.kameleoon.userpost.entity.User;
import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.model.UserDto;
import com.kameleoon.userpost.persistence.PostRepository;
import com.kameleoon.userpost.service.PostService;
import com.kameleoon.userpost.service.PostVoteService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final PostVoteService<PostLike> postLikeService;
    private final PostVoteService<PostDislike> postDislikeService;
    private final ModelMapper mapper;

    @Override
    public Post findByID(long id) throws ServiceException {
        return repository.findById(id)
                .orElseThrow(() -> new ServiceException("123"));              //TODO: FINISH EXCEPTION
    }

    @Override
    public List<PostDto> findByPage(int page, int size, String filter, String direction) {
        return repository.findAll(PageRequest.of(page,size, Sort.by(filter).ascending()))
                .stream()
                .map(i -> mapper.map(i,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByUser(String login, int page, int size, String filter, String direction) {
        return repository.findPostByUser_Login(login,PageRequest.of(page,size, Sort.by(filter).ascending()))
                .stream()
                .map(i -> mapper.map(i,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByUserLast(String login) {
        int size = 5;
        int page = 0;
        String filter = "postedDate";
        String direction = "desc";
        return findByUser(login,page,size,filter,direction);
    }

    @Override
    public List<PostDto> findTopPost() {        //TODO: FINISH METHOD
        return null;
    }

    @Override
    public List<PostDto> findFlopPost() {       //TODO FINISH METHOD
        return null;
    }

    @Override
    public PostDto findRandomPost() {
        return mapper.map(repository.findRandomPost(), PostDto.class);
    }

    @Override
    public void savePost(PostDto post) {
        repository.save(mapper.map(post,Post.class));
    }

    @Override
    public void updatePost(long id, PostDto post) {
        post.setId(id);
        repository.save(mapper.map(post,Post.class));
    }

    @Override
    public void deletePost(long id, UserDto user) throws ServiceException {
        Post byID = findByID(id);
        if(!byID.getUser()     //TODO: FINISH EXCEPTION
                .getLogin()
                .equals(user.getLogin())) {
            throw new ServiceException();
        }
        repository.delete(byID);
    }

    @Override
    public void likePost(long id, UserDto user) throws ServiceException {
        postLikeService.saveVote(mapper.map(user, User.class),findByID(id));
    }

    @Override
    public void dislikePost(long id, UserDto user) throws ServiceException {
        postDislikeService.saveVote(mapper.map(user, User.class),findByID(id));
    }

    @Override
    public void deleteLikePost(long id, UserDto user) throws ServiceException {
        postLikeService.deleteVote(mapper.map(user, User.class),findByID(id));
    }

    @Override
    public void deleteDislikePost(long id, UserDto user) throws ServiceException {
        postDislikeService.deleteVote(mapper.map(user, User.class),findByID(id));
    }
}
