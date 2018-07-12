package com.rap.microservices.handlers;

import com.rap.microservices.model.Requisition;
import com.rap.microservices.repositories.RequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class RequisitionHandler {

	
	@Autowired
    private RequisitionRepository reqisitionRepository;

    @GetMapping
    public Mono<ServerResponse> findByRequisitionId(ServerRequest request) {
        return this.reqisitionRepository.findById(request.pathVariable("requisitionId"))
                .flatMap(requisition -> ServerResponse.ok().body(Mono.just(requisition), Requisition.class))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    @GetMapping
    public Mono<ServerResponse> addUser(ServerRequest request) {

        return request.bodyToMono(Requisition.class)
                .flatMap(requisition -> this.reqisitionRepository.save(requisition))
                .flatMap(p -> ServerResponse.created(URI.create(request.path() + "/" + p.getRequisitionId())).build());
    }


	
}
