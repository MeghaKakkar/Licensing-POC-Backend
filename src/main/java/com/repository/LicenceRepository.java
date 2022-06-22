package com.repository;

import com.model.Licence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LicenceRepository extends MongoRepository<Licence, String> {

    Optional<Licence> findByKey(String key);

    Optional<Licence> findByApplicationName(String applicationName);

}
