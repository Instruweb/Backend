package com.instruweb.service;

import com.instruweb.domain.Product;
import com.instruweb.domain.User;
import com.instruweb.repository.ProductRepository;
import io.quarkus.elytron.security.common.BcryptUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.core.Response;
import java.net.URI;

@ApplicationScoped
public class ProductService {
    @Inject
    ProductRepository productRepository;

    public ProductService() {}

    public Product getProduct(String name) {
        Product product = productRepository.find("name", name).firstResult();

        if (product == null) {
            throw new NotFoundException();
        }

        return product;
    }

    public Product createProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException();
        }

        productRepository.persist(product);

        return product;
    }
}
