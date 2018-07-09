package com.rap.services.controllers;

import com.rap.services.models.Requisition;
import com.rap.services.models.User;
import com.rap.services.repositories.RequisitionRepository;
import com.rap.services.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RoutesConfiguration {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private RequisitionRepository requisitionRepository;


    @Bean
    RouterFunction<?> routes(UserHandler userHandler, RequisitionHandler requisitionHandler) {
        return nest(accept(MediaType.APPLICATION_JSON),
                route(RequestPredicates.GET("/user/{userId}"), userHandler::findByUserId))
                .andRoute(RequestPredicates.POST("/user"), userHandler::addUser)
                .andRoute(RequestPredicates.GET("/user"),
                        request -> ServerResponse.ok().body(userRespository.findAll(), User.class))
                .andRoute(RequestPredicates.GET("/requisition/{requisitionId}"), requisitionHandler::findByRequisitionId)
                .andRoute(RequestPredicates.GET("/requisition"),
                        request -> ServerResponse.ok().body(requisitionRepository.findAll(), Requisition.class))
                .andRoute(RequestPredicates.POST("/requisition"), requisitionHandler::addUser);
    }


}
