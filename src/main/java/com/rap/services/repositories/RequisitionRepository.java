package com.rap.services.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rap.services.models.Requisition;


public interface RequisitionRepository extends ReactiveMongoRepository<Requisition,String>{
}
