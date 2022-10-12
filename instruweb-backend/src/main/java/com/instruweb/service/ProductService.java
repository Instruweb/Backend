package com.instruweb.service;

import com.instruweb.domain.Product;
import com.instruweb.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;

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
}
