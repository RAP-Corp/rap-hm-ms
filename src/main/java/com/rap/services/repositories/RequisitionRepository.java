package com.rap.services.repositories;

import com.rap.services.models.Requisition;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequisitionRepository extends ReactiveMongoRepository<Requisition,String>{
}
