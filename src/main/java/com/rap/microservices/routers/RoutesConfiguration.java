package com.rap.microservices.routers;

import com.rap.microservices.handlers.ErrorHandler;
import com.rap.microservices.handlers.RequisitionHandler;
import com.rap.microservices.handlers.UserHandler;
import com.rap.microservices.model.Requisition;
import com.rap.microservices.model.User;
import com.rap.microservices.repositories.RequisitionRepository;
import com.rap.microservices.repositories.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class RoutesConfiguration {

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private RequisitionRepository requisitionRepository;


    @Bean
    RouterFunction<?> routes(UserHandler userHandler, RequisitionHandler requisitionHandler, ErrorHandler errorHandler) {
        return nest(accept(MediaType.APPLICATION_JSON),
                route(GET("/user/{userId}"), userHandler::findByUserId))
                .andRoute(POST("/user"), userHandler::addUser)
                .andRoute(GET("/user"), request -> ServerResponse.ok().body(userRespository.findAll(), User.class))
                .andRoute(GET("/requisition/{requisitionId}"), requisitionHandler::findByRequisitionId)
                .andRoute(GET("/requisition"), request -> ServerResponse.ok().body(requisitionRepository.findAll(), Requisition.class))
                .andRoute(POST("/requisition"), requisitionHandler::addUser)
                .andOther(route(RequestPredicates.all(), errorHandler::notFound));
    }


}
