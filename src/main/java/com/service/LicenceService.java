package com.service;

import com.model.LicenceEntity;
import com.repository.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class LicenceService {

    @Autowired
    private LicenceRepository licenceRepository;


    public ResponseEntity<LicenceEntity> getById(int id) {
        Optional<LicenceEntity> licence = licenceRepository.findById(id);
        if (licence.isPresent())
            return new ResponseEntity(licence.get(), new HttpHeaders(), HttpStatus.OK);
        else
            return new ResponseEntity(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<HttpStatus> create(LicenceEntity entity) {
        ResponseEntity<LicenceEntity> responseEntity = getById(entity.getId());
        if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
            licenceRepository.save(entity);
            return new ResponseEntity(HttpStatus.CREATED);
        } else {
            return new ResponseEntity(HttpStatus.FOUND);
        }
    }


    @Transactional
    public ResponseEntity<HttpStatus> update(LicenceEntity entity) {
        ResponseEntity<LicenceEntity> responseEntity = getById(entity.getId());
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            responseEntity.getBody().setId(entity.getId());
            responseEntity.getBody().setName(entity.getName());
            return new ResponseEntity(HttpStatus.OK);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteById(int id) {
        ResponseEntity<LicenceEntity> responseEntity = getById(id);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            licenceRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
