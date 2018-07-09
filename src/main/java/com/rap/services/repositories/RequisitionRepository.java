package com.rap.services.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.rap.services.models.Requisition;

import reactor.core.publisher.Flux;

@Repository
public interface RequisitionRepository extends ReactiveMongoRepository<Requisition,String>{
    Flux<Requisition> findByRequisitionId(String requisitionId);
}
