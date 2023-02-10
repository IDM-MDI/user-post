package com.kameleoon.userpost.service.impl;

import com.kameleoon.userpost.entity.Post;
import com.kameleoon.userpost.entity.PostDislike;
import com.kameleoon.userpost.entity.PostLike;
import com.kameleoon.userpost.entity.User;
import com.kameleoon.userpost.exception.ServiceException;
import com.kameleoon.userpost.handler.DirectionHandler;
import com.kameleoon.userpost.model.PostDto;
import com.kameleoon.userpost.model.UserDto;
import com.kameleoon.userpost.persistence.PostRepository;
import com.kameleoon.userpost.service.PostService;
import com.kameleoon.userpost.service.PostVoteService;
import com.kameleoon.userpost.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableTransactionManagement(proxyTargetClass = true)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository repository;
    private final PostVoteService<PostLike> postLikeService;
    private final PostVoteService<PostDislike> postDislikeService;
    private final UserService service;
    private final ModelMapper mapper;

    @Override
    public Post findByID(long id) throws ServiceException {
        return repository.findById(id)
                .orElseThrow(() -> new ServiceException("123"));              //TODO: FINISH EXCEPTION
    }

    @Override
    public List<PostDto> findByPage(int page, int size, String filter, String direction) {
        return repository.findAll(PageRequest.of(page,size, DirectionHandler.getDirection(Sort.by(filter),direction)))
                .stream()
                .map(i -> mapper.map(i,PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PostDto> findByUser(String login, int page, int size, String filter, String direction) {
        return repository.findPostByUser_Login(login,PageRequest.of(page,size, DirectionHandler.getDirection(Sort.by(filter),direction)))
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
    @Transactional
    public void savePost(String login, PostDto post) {
        Post map = mapper.map(post, Post.class);
        map.setUser(mapper.map(service.findUser(login),User.class));
        repository.save(map);
    }

    @Override
    public void updatePost(String login, long id, PostDto post) throws ServiceException {
        Post byID = findByID(id);
        post.setId(id);
        post.setUser(service.findUser(login));
        post.setPostedDate(byID.getPostedDate());
        repository.save(mapper.map(post,Post.class));
    }

    @Override
    public void deletePost(String login, long id) throws ServiceException {
        Post byID = findByID(id);
        UserDto user = service.findUser(login);
        if(!byID.getUser()     //TODO: FINISH EXCEPTION
                .getLogin()
                .equals(user.getLogin())) {
            throw new ServiceException();
        }
        repository.delete(byID);
    }

    @Override
    public void likePost(String login, long id) throws ServiceException {
        postLikeService.saveVote(mapper.map(login, User.class),findByID(id));
    }

    @Override
    public void dislikePost(String login, long id) throws ServiceException {
        postDislikeService.saveVote(mapper.map(login, User.class),findByID(id));
    }

    @Override
    public void deleteLikePost(String login, long id) throws ServiceException {
        postLikeService.deleteVote(mapper.map(login, User.class),findByID(id));
    }

    @Override
    public void deleteDislikePost(String login, long id) throws ServiceException {
        postDislikeService.deleteVote(mapper.map(login, User.class),findByID(id));
    }
}
