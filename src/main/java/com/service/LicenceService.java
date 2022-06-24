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

	
    public List<Licence> getByApplicationName(String applicationName) {
    	 Iterable<Licence> listIterator = licenceRepository.findByApplicationName(applicationName); 
		  List<Licence> list = new ArrayList<>();
		  listIterator.forEach(e->list.add(e));
		  return list;
        
    }

    public void create(Licence license) {
            licenceRepository.save(license);
    }


	
	  public void deleteById(Long id) {
		  licenceRepository.deleteById(id);
		}
	 

}
