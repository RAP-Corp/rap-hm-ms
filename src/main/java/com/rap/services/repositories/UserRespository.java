package com.rap.services.repositories;

import com.rap.services.models.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRespository extends ReactiveMongoRepository<User, String> {

}
