package com.instruweb;

import com.instruweb.domain.User;
import com.instruweb.repository.UserRepository;
import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class Startup {
    @Inject
    UserRepository userRepository;

    @Transactional
    public void loadUsers(@Observes StartupEvent evt) {
        User user = new User();

        user.setUsername("Nickwelles");
        user.setEmailaddress("nick@welles.com");
        user.setPassword(BcryptUtil.bcryptHash("ditiseenwachtwoord"));
        user.setPhonenumber("0622280709");
        user.setFirstname("Nick");
        user.setLastname("Welles");
        user.setVerified(true);
        user.setRole("admin");
        user.setAddress("Sintelweg 1");
        user.setPostalcode("5971 PC");

        userRepository.persist(user);
    }
}
