package com.instruweb;

import com.instruweb.domain.MainCategory;
import com.instruweb.domain.Product;
import com.instruweb.domain.User;
import com.instruweb.repository.MainCategoryRepository;
import com.instruweb.repository.ProductRepository;
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

    @Inject
    MainCategoryRepository mainCategoryRepository;

    @Inject
    ProductRepository productRepository;

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

    @Transactional
    public void loadCategories(@Observes StartupEvent evt) {
        MainCategory mainCategory = new MainCategory();
        MainCategory mainCategory2 = new MainCategory();

        mainCategory.setName("Gitaar");
        mainCategory2.setName("Akoestische Gitaar");

        mainCategoryRepository.persist(mainCategory);
        mainCategoryRepository.persist(mainCategory2);
    }

    @Transactional
    public void loadProducts(@Observes StartupEvent evt) {
        Product product = new Product();
        Product product2 = new Product();

        product.setName("Gitaar");
        product.setDescription("Een mooie gitaar met 6 snaren.");
        product.setImage("null");
        product.setSupply("Full");
        product.setMain_categoryId(1);
        product.setSub_categoryId(1);

        product2.setName("Fender Gitaar");
        product2.setDescription("Een mooie gitaar van Fender met 6 snaren.");
        product2.setImage("null");
        product2.setSupply("Full");
        product2.setMain_categoryId(1);
        product2.setSub_categoryId(1);

        productRepository.persist(product);
        productRepository.persist(product2);
    }
}
