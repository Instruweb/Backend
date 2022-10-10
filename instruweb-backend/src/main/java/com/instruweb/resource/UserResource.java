package com.instruweb.resource;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.instruweb.domain.User;
import com.instruweb.service.UserService;

import java.net.URI;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/users")
public class UserResource {
    @Inject
    UserService userService;

    public UserResource(){}

    @GET
    @Path("/{emailaddress}")
    public User getUser(String emailaddress) {
        return userService.getUser(emailaddress);
    }

    @POST
    @Transactional
    public Response createUser(User user) {
        User userWithId = userService.createUser(user);
        return Response.created(URI.create("/users/" + userWithId.getId())).build();
    }
}
