package com.repository;

import com.model.LicenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenceRepository extends JpaRepository<LicenceEntity, Integer> {

}
