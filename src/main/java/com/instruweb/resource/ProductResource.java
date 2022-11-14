package com.instruweb.resource;

import com.instruweb.domain.Product;
import com.instruweb.service.ProductService;
import io.quarkus.security.Authenticated;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/api/products")
@Authenticated
public class ProductResource {
    @Inject
    ProductService productService;

    public ProductResource() {}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Product getProduct(String name) {
        return productService.getProduct(name);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/id/{id}")
    public Product getProductById(Integer id) {
        return productService.getProductById(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() { return productService.getAllProducts(); }

    @GET
    @Path("/main_category/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProductsByMainCategoryId(Integer id) { return productService.getAllProductsByMainCategoryId(id); }

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createProduct(Product product) {
        Product productWithId = productService.createProduct(product);
        return Response.created(URI.create("/api/products/" + productWithId.getId())).build();
    }
}
