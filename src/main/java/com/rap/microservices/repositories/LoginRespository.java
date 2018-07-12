package com.rap.microservices.repositories;

import com.rap.microservices.model.Login;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRespository extends ReactiveMongoRepository<Login, String> {
}
