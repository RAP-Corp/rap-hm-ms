package com.rap.microservices.repositories;

import com.rap.microservices.model.Requisition;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionRepository extends ReactiveMongoRepository<Requisition,String>{
}
