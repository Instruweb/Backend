package com.instruweb.service;

import com.instruweb.domain.User;
import com.instruweb.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class UserService {
    @Inject
    UserRepository userRepository;

    public UserService() {}

    public User getUser(String emailaddress) {
        User user = userRepository.find("emailaddress", emailaddress).firstResult();

        if (user == null) {
            throw new NotFoundException();
        }

        return user;
    }

    public User createUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }

        user.setPassword(BcryptUtil.bcryptHash(user.getPassword()));

        userRepository.persist(user);

        return user;
    }
}
