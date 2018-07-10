package com.rap.services.repositories;

import com.rap.services.models.User;

import reactor.core.publisher.Mono;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRespository extends ReactiveMongoRepository<User, String> {
Mono<User>  findByUserEmailAddress(Mono<User> mono);
}
