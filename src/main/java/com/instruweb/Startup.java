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

        user.setUsername("admin");
        user.setEmailaddress("nick@welles.com");
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
        Product product3 = new Product();

        product.setName("Gitaar");
        product.setPrice(250.6);
        product.setDescription("Een mooie gitaar met 6 snaren.");
        product.setImage("gitaar.webp");
        product.setSupply("Full");
        product.setMain_categoryId(1);
        product.setSub_categoryId(1);

        product2.setName("Fender Gitaar");
        product2.setPrice(350.2);
        product2.setDescription("Een mooie gitaar van Fender met 6 snaren.");
        product2.setImage("fender_gitaar.jpg");
        product2.setSupply("Full");
        product2.setMain_categoryId(1);
        product2.setSub_categoryId(2);

        product3.setName("Les Paul Gitaar");
        product3.setPrice(499.99);
        product3.setDescription("Een mooie gitaar van Les Paul met 7 snaren.");
        product3.setImage("gitaar.webp");
        product3.setSupply("Half");
        product3.setMain_categoryId(2);
        product3.setSub_categoryId(1);

        productRepository.persist(product);
        productRepository.persist(product2);
        productRepository.persist(product3);
    }
}
