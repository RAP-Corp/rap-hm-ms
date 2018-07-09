package com.rap.services.controllers;

import com.rap.services.models.User;
import com.rap.services.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class UserHandler {

    @Autowired
    private UserRespository userRespository;

    @GetMapping
    public Mono<ServerResponse> findByUserId(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<User> userMono = this.userRespository.findById(request.pathVariable("userId"));
        return userMono
                .flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(user)))
                .switchIfEmpty(notFound);
    }

    @GetMapping
    public Mono<ServerResponse> addUser(ServerRequest request) {
        return ServerResponse.ok().build(user -> {
            userRespository.insert(request.bodyToMono(User.class)).subscribe();
            user.onComplete();
        });
    }

}
