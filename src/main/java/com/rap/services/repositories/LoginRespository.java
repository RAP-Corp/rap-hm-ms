package com.rap.services.repositories;

import com.rap.services.models.Login;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LoginRespository extends ReactiveMongoRepository<Login, String> {
}
