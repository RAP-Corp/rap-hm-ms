package com.rap.microservices.repositories;

import com.rap.microservices.model.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
@Repository
public interface RoleRepository extends ReactiveMongoRepository<Role, String> {
    Mono<Role> findById(String role);
}
