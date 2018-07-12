package com.rap.microservices.repositories;

import com.rap.microservices.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRespository extends ReactiveMongoRepository<User, String> {
Mono<User> findByemail(String loginId);
}
