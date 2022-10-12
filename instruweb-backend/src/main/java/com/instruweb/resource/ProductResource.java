package com.instruweb.resource;

import com.instruweb.domain.Product;
import com.instruweb.domain.User;
import com.instruweb.service.ProductService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

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

    @POST
    @RolesAllowed("admin")
    @Transactional
    public Response createProduct(Product product) {
        Product productWithId = productService.createProduct(product);
        return Response.created(URI.create("/api/products/" + productWithId.getId())).build();
    }
}
