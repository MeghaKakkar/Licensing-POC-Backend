package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.model.Licence;
import com.repository.LicenceRepository;

@Service
public class LicenceService {

    @Autowired
    private LicenceRepository licenceRepository;


	
	  public List<Licence> getAll() { 

		  Iterable<Licence> listIterator = licenceRepository.findAll(); 
		  List<Licence> list = new ArrayList<>();
		  listIterator.forEach(e->list.add(e));
		  return list;
		  
		  }
	 

    public Licence getById(Long id) {
        Optional<Licence> licence = licenceRepository.findById(id);
        return licence.orElse(new Licence());
    }

	/*
	 * public ResponseEntity<Licence> getByKey(String key) { Optional<Licence>
	 * licence = licenceRepository.findByKey(key); return licence.map(licenceEntity
	 * -> new ResponseEntity<>(licenceEntity, new HttpHeaders(),
	 * HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(),
	 * HttpStatus.NOT_FOUND)); }
	 */
    public ResponseEntity<Licence> getByApplicationName(String applicationName) {
        Optional<Licence> licence = licenceRepository.findByApplicationName(applicationName);
        return licence.map(licenceEntity -> new ResponseEntity<>(licenceEntity, new HttpHeaders(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, new HttpHeaders(), HttpStatus.NOT_FOUND));
    }

    public void create(Licence license) {
            licenceRepository.save(license);
    }


	/*
	 * public ResponseEntity<HttpStatus> update(String id, Licence entity) {
	 * ResponseEntity<Licence> responseEntity = getById(id); if
	 * (responseEntity.getStatusCode() == HttpStatus.OK) {
	 * responseEntity.getBody().setKey(entity.getKey());
	 * responseEntity.getBody().setApplicationName(entity.getApplicationName());
	 * return new ResponseEntity<>(HttpStatus.OK); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */

	/*
	 * public ResponseEntity<HttpStatus> deleteByKey(String key) {
	 * ResponseEntity<Licence> responseEntity = getByKey(key);
	 * 
	 * if (responseEntity.getStatusCode() == HttpStatus.OK) {
	 * licenceRepository.deleteById(responseEntity.getBody().getId()); return new
	 * ResponseEntity<>(HttpStatus.OK); } else { return new
	 * ResponseEntity<>(HttpStatus.NOT_FOUND); } }
	 */

}
