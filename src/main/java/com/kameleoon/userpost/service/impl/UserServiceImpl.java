package com.kameleoon.userpost.service.impl;

import com.kameleoon.userpost.entity.User;
import com.kameleoon.userpost.model.UserDto;
import com.kameleoon.userpost.persistence.UserRepository;
import com.kameleoon.userpost.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public UserDto findUser(String login) {
        return repository.findUserByLogin(login)
                .map(i -> mapper.map(i, UserDto.class))
                .orElseThrow(() -> new ServiceException("123")); // TODO: FINISH EXCEPTION
    }

    @Override
    public UserDto saveUser(UserDto user) {
        if(repository.existsUserByLogin(user.getLogin())) {
            throw new ServiceException("123");                  //TODO: FINISH EXCEPTION
        }
        User userEntity = mapper.map(user, User.class);
        User savedEntity = repository.save(userEntity);
        return mapper.map(savedEntity, UserDto.class);
    }
}
