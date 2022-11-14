package com.instruweb.resource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.instruweb.domain.User;
import com.instruweb.service.UserService;
import io.quarkus.security.Authenticated;
import io.quarkus.security.UnauthorizedException;
import io.quarkus.security.identity.SecurityIdentity;
import org.jboss.resteasy.reactive.NoCache;

import java.net.URI;
import java.util.Objects;

@Authenticated
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/api/users")
public class UserResource {

    @Inject
    UserService userService;

    @Inject
    SecurityIdentity identity;

    public UserResource(){}

    @GET
    @Path("/{emailaddress}")
    @NoCache
    public User getUser(String emailaddress) {
        return userService.getUser(emailaddress);
    }

    @GET
    @Path("/me")
    @Produces(MediaType.TEXT_PLAIN)
    public String user() {
        User user = userService.getUser("nick@welles.com");
        return user.getEmailaddress();
    }
}
