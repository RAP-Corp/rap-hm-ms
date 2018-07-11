package com.rap.services.controllers;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	Logger log = LoggerFactory.getLogger(LoginHandler.class);
	
	@Autowired 
	private UserRespository userRespository;
	
	@PostMapping
    public Mono<ServerResponse> loginUser(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        String loginId = request.pathVariable("loginId");
        String password = request.pathVariable("password");
        Mono<User> userMono = this.userRespository.findByUserEmailAddress(loginId);
        return userMono
        		.map(user -> {
        			if (StringUtils.isNotBlank(user.getPassword()) && user.getPassword().equalsIgnoreCase(password)) {
						log.info(" user password is  : {}  " ,password);
        			return user;
        			}else {
        				log.info(" invalid password  : {}  " ,password);
        				return notFound;
        			}
             	   
                })
               .flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(user))   )
                .switchIfEmpty(notFound);
    }

}
