package com.rap.services.controllers;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.rap.services.models.User;
import com.rap.services.repositories.UserRespository;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {
	Logger logger = LoggerFactory.getLogger(UserHandler.class);

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
        	Mono<User> userMono = null;
        	try {
        		userMono =request.bodyToMono(User.class);
        	}catch(Exception exp ) {
        		logger.info(" Exeception in converting body to mono  ");
        	}
        	userRespository.insert(userMono).subscribe();
            user.onComplete();
        });
    }

}
