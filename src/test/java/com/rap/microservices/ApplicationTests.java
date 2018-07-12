package com.rap.microservices;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    ApplicationContext context;

    WebTestClient client;

    @Before
    public void setup() {
        client = WebTestClient
                .bindToApplicationContext(context)
                .configureClient()
                .baseUrl("http://localhost:8080/")
                .build();
    }

    @Test
    public void getAllUserShouldBeOk() {
        client
                .get()
                .uri("/user")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void getANoneExistedUserShouldReturn404() {
        client
                .get()
                .uri("/user/test")
                .exchange()
                .expectStatus().isNotFound();
    }
}
