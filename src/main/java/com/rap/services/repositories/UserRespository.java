package com.rap.services.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.rap.services.models.User;

import reactor.core.publisher.Mono;

public interface UserRespository extends ReactiveMongoRepository<User, String> {
Mono<User>  findByUserEmailAddress(String loginId);
}
