package com.instruweb.resource;

import com.instruweb.domain.Product;
import com.instruweb.service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/products")
public class ProductResource {
    @Inject
    ProductService productService;

    public ProductResource() {}

    @GET
    @Path("/{name}")
    public Product getProduct(String name) {
        return productService.getProduct(name);
    }
}
