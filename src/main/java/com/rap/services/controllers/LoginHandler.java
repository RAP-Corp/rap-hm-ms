package com.rap.services.controllers;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.rap.services.models.User;
import com.rap.services.repositories.UserRespository;

import reactor.core.publisher.Mono;

@Component
public class LoginHandler {
	
	private UserRespository userRespository;
	
	@PostMapping
    public Mono<ServerResponse> loginUser(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<User> userMono = this.userRespository.findByUserEmailAddress(request.bodyToMono(User.class));
        return userMono
                .flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(user)))
                .switchIfEmpty(notFound);
    }

}
