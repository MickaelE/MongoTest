package com.mickenet.mongotest;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface RegistrationRepository extends MongoRepository<Registration, UUID> {
    List<Registration> findAll();

}
