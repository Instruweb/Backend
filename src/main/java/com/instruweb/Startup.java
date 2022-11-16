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

        user.setUsername("nickwelles");
        user.setEmailaddress("nick@welles.com");
        user.setPhonenumber("0622280709");
        user.setAddress("Sintelweg 1");
        user.setPostalcode("5971 PC");

        userRepository.persist(user);
    }

    @Transactional
    public void loadCategories(@Observes StartupEvent evt) {
        MainCategory mainCategory = new MainCategory();
        MainCategory mainCategory2 = new MainCategory();
        MainCategory mainCategory3 = new MainCategory();
        MainCategory mainCategory4 = new MainCategory();

        mainCategory.setName("Gitaren");
        mainCategory.setImage("gitaren.png");
        mainCategory2.setName("Hoofdtelefoons");
        mainCategory2.setImage("hoofdtelefoons.png");
        mainCategory3.setName("Microfoons");
        mainCategory3.setImage("microfoons.png");
        mainCategory4.setName("Studio & Recording");
        mainCategory4.setImage("studio.webp");

        mainCategoryRepository.persist(mainCategory);
        mainCategoryRepository.persist(mainCategory2);
        mainCategoryRepository.persist(mainCategory3);
        mainCategoryRepository.persist(mainCategory4);
    }

    @Transactional
    public void loadProducts(@Observes StartupEvent evt) {
        Product product = new Product();
        Product product2 = new Product();
        Product product3 = new Product();
        Product product4 = new Product();

        product.setName("Gitaar");
        product.setPrice(250.6);
        product.setDescription("Een mooie gitaar met 6 snaren.");
        product.setImage("fazely.png");
        product.setSupply("Full");
        product.setMain_categoryId(1);
        product.setSub_categoryId(1);

        product2.setName("Fender Gitaar");
        product2.setPrice(350.2);
        product2.setDescription("Een mooie gitaar van Fender met 6 snaren.");
        product2.setImage("fender_gitaar.jpg");
        product2.setSupply("Full");
        product2.setMain_categoryId(1);
        product2.setSub_categoryId(1);

        product3.setName("Les Paul Gitaar");
        product3.setPrice(499.99);
        product3.setDescription("Een mooie gitaar van Les Paul met 7 snaren.");
        product3.setImage("gitaar.webp");
        product3.setSupply("Half");
        product3.setMain_categoryId(1);
        product3.setSub_categoryId(1);

        product4.setName("Devine koptelefoon");
        product4.setPrice(159.99);
        product4.setDescription("Een mooie koptelefoon die je kunt gebruiken in de studio om bijvoorbeeld te mixen/masteren of om muziek op te luisteren.");
        product4.setImage("koptelefoon2.webp");
        product4.setSupply("Half");
        product4.setMain_categoryId(2);
        product4.setSub_categoryId(1);

        productRepository.persist(product);
        productRepository.persist(product2);
        productRepository.persist(product3);
        productRepository.persist(product4);
    }
}
