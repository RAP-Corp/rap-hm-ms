package com.rap.services.controllers;

import com.rap.services.models.User;
import com.rap.services.repositories.UserRespository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class RoutesConfiguration {

    @Bean
    RouterFunction<?> routes(UserRespository userRespository) {
        return nest(path ("/user"),

          route(RequestPredicates.GET("/{id}"),
            request -> ok().body(userRespository.findByuserId(request.pathVariable("id")), User.class))

            .andRoute(method(HttpMethod.POST),
              request -> {
                  userRespository.insert(request.bodyToMono(User.class)).subscribe();
            return ok().build();
        })
        );
    }
}
