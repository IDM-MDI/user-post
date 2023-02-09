package com.kameleoon.userpost.service.impl;

import com.kameleoon.userpost.entity.User;
import com.kameleoon.userpost.model.UserDto;
import com.kameleoon.userpost.persistence.UserRepository;
import com.kameleoon.userpost.security.JwtTokenProvider;
import com.kameleoon.userpost.security.JwtUser;
import com.kameleoon.userpost.service.UserService;
import com.kameleoon.userpost.utils.HashGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final AuthenticationManager manager;
    private final JwtTokenProvider provider;
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
        User save = repository.save(mapper.map(user, User.class));
        UserDto savedDto = mapper.map(save, UserDto.class);
        savedDto.setJwt(provider.createToken(savedDto));
        return savedDto;
    }

    @Override
    public UserDto authorization(UserDto user) {
        authenticateByManager(user);
        return findUser(user.getLogin());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = findUser(username);
        JwtUser jwtUser = new JwtUser(user);
        log.info("user with username - {} successfully loaded", username);
        return jwtUser;
    }

    private void authenticateByManager(UserDto user) {
        manager.authenticate(new UsernamePasswordAuthenticationToken(user.getLogin(),
                HashGenerator.generateBySHA(user.getPassword())));
    }
}
