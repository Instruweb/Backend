package com.instruweb;

import com.instruweb.resource.UserResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@TestHTTPEndpoint(UserResource.class)
public class ExampleResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get()
                .then()
                .statusCode(405);
    }

}