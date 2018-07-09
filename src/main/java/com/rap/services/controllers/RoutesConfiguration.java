package com.rap.services.controllers;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import com.rap.services.models.Requisition;
import com.rap.services.models.User;
import com.rap.services.repositories.RequisitionRepository;
import com.rap.services.repositories.UserRespository;

import reactor.core.publisher.Flux;

@Configuration
public class RoutesConfiguration {

    @Bean
    RouterFunction<?> routes(UserRespository userRespository,RequisitionRepository requisitionRepository) {
        	return	RouterFunctions.route(RequestPredicates.GET("/user/{id}"),
            request -> ok().body(userRespository.findByuserId(request.pathVariable("id")), User.class))
            .andRoute(RequestPredicates.POST("/user"),
              request -> {
            	  System.out.println("Before handler invocation: " + request.path());
                  userRespository.insert(request.bodyToMono(User.class)).subscribe();
                  System.out.println("After handler invocation: " + request.path());
            return ok().build();
        })
            .andRoute(RequestPredicates.GET("/requisition/{requisitionId}"),
                    request -> {
                    	Flux<Requisition> requisitionFlux=requisitionRepository.findByRequisitionId(request.pathVariable("requisitionId"));
                    	System.out.println("Before requisition handler invocation: " + request.path());
                    	return ok().body(requisitionFlux, Requisition.class);
                    	}
                    )
            .andRoute(RequestPredicates.POST("/requisition"),
                    request -> {
                  	  System.out.println("Before requisition POST handler invocation: " + request.path());
                  	  requisitionRepository.insert(request.bodyToMono(Requisition.class)).subscribe();
                  	  System.out.println("After requisition POST handler invocation: " + request.path());
                  return ok().build();
              })
        ;
    }
    
     
    
}
