package com.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.Licence;

@Repository
public interface LicenceRepository extends CrudRepository<Licence, Long> {

    List<Licence> findByApplicationName(String applicationName);

}
