package com.rap.services.repositories;

import com.rap.services.models.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserRespository extends ReactiveMongoRepository<User, String> {
    Flux<User> findByuserId(String id);
}
