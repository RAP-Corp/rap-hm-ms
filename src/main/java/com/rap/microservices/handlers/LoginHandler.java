package com.rap.microservices.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rap.microservices.repositories.UserRespository;

@Component
public class LoginHandler {
	Logger log = LoggerFactory.getLogger(LoginHandler.class);

	@Autowired 
	private UserRespository userRespository;
	
	/*@PostMapping
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
    }*/

}
