package com.service;

import com.model.Licence;
import com.repository.LicenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LicenceService {

    @Autowired
    private LicenceRepository licenceRepository;


    public List<Licence> getAll() {
        return licenceRepository.findAll();
    }

    public ResponseEntity<Licence> getById(String id) {
        Optional<Licence> licence = licenceRepository.findById(id);
        return licence.map(licenceEntity -> new ResponseEntity<>(licenceEntity, new HttpHeaders(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Licence> getByKey(String key) {
        Optional<Licence> licence = licenceRepository.findByKey(key);
        return licence.map(licenceEntity -> new ResponseEntity<>(licenceEntity, new HttpHeaders(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<Licence> getByApplicationName(String applicationName) {
        Optional<Licence> licence = licenceRepository.findByApplicationName(applicationName);
        return licence.map(licenceEntity -> new ResponseEntity<>(licenceEntity, new HttpHeaders(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    public ResponseEntity<HttpStatus> create(Licence entity) {
        ResponseEntity<Licence> responseEntity = getByKey(entity.getKey());
        if (responseEntity.getStatusCode() == HttpStatus.NOT_FOUND) {
            licenceRepository.save(entity);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.FOUND);
        }
    }


    public ResponseEntity<HttpStatus> update(String id, Licence entity) {
        ResponseEntity<Licence> responseEntity = getById(id);
        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            responseEntity.getBody().setKey(entity.getKey());
            responseEntity.getBody().setApplicationName(entity.getApplicationName());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteByKey(String key) {
        ResponseEntity<Licence> responseEntity = getByKey(key);

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            licenceRepository.deleteById(responseEntity.getBody().getId());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
