package com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Licence;

@Repository
public interface LicenceRepository extends CrudRepository<Licence, Long> {

    Optional<Licence> findByProductKey(String key);

    Optional<Licence> findByApplicationName(String applicationName);

}
