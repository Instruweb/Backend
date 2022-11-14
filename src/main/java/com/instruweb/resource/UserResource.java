package com.instruweb.resource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.instruweb.domain.User;
import com.instruweb.service.UserService;

@Path("/api/users")
public class UserResource {

    @Inject
    UserService userService;

    public UserResource(){}

    @GET
    @Path("/{emailaddress}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(String emailaddress) {
        return userService.getUser(emailaddress);
    }
}
