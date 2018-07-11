package com.rap.services.controllers;

import com.rap.services.models.Requisition;
import com.rap.services.repositories.RequisitionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class RequisitionHandler {

	
	@Autowired
    private RequisitionRepository reqisitionRepository;

    @GetMapping
    public Mono<ServerResponse> findByRequisitionId(ServerRequest request) {
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<Requisition> userMono = this.reqisitionRepository.findById(request.pathVariable("requisitionId"));
        return userMono
                .flatMap(user -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(fromObject(user)))
                .switchIfEmpty(notFound);
    }

    @GetMapping
    public Mono<ServerResponse> addRequisition(ServerRequest request) {
        return ServerResponse.ok().build(user -> {
            reqisitionRepository.insert(request.bodyToMono(Requisition.class)).subscribe();
            user.onComplete();
        });
    }


	
}
