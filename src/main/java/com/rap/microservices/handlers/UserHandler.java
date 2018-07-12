package com.rap.microservices.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import java.net.URI;
import java.util.Arrays;
import java.util.HashSet;

import com.rap.microservices.model.User;
import com.rap.microservices.repositories.UserRespository;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private ErrorHandler errorHandler;

    @GetMapping
    public Mono<ServerResponse> findByUserId(ServerRequest request) {
        return this.userRespository.findById(request.pathVariable("userId"))
                .flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

 /*   @GetMapping
    public Mono<ServerResponse> addUser(ServerRequest request) {
        return request.bodyToMono(User.class)
                .flatMap(user -> this.userRespository.insert(user))
                .flatMap(p -> ServerResponse.created(URI.create(request.path() + "/" + p.getUserId())).build())
                .onErrorResume(errorHandler::throwableError);

    }*/

   @GetMapping
    public Mono<ServerResponse> addUser(ServerRequest request) {
        return request.bodyToMono(User.class)
                .flatMap(user-> {
                    user.setRoles(new HashSet<>(Arrays.asList("USER","ADMIN")));
                    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
                    user.setEnabled(true);
                    return this.userRespository.insert(user);
                })
                .flatMap(p -> ServerResponse.created(URI.create("/user/" + p.getUserId())).build())
                .onErrorResume(errorHandler::throwableError);
    }
}