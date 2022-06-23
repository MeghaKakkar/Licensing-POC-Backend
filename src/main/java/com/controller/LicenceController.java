package com.controller;

import com.model.Licence;
import com.service.LicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/licence")
public class LicenceController {

	@Autowired
	private LicenceService licenceService;
	
	  
	  @GetMapping 
	  public List<Licence> getAll() { return licenceService.getAll(); }
	 

	@GetMapping("/getById/{id}")
	public Licence getById(@PathVariable Long id) {
		return licenceService.getById(id);
	}

	/*
	 * @GetMapping("/getByKey/{key}") public ResponseEntity<Licence>
	 * getByKey(@PathVariable String key) { return licenceService.getByKey(key); }
	 */

	@GetMapping("/getByApplicationName/{applicationName}")
	public ResponseEntity<Licence> getByApplicationName(@PathVariable String applicationName) {
		return licenceService.getByApplicationName(applicationName);
	}

	@PostMapping
	public void create(@RequestBody Licence licence) {
		licenceService.create(licence);
	}

	/*
	 * @PutMapping public ResponseEntity<HttpStatus> update(@RequestParam String
	 * id, @RequestBody Licence licence) { return licenceService.update(id,
	 * licence); }
	 * 
	 * @DeleteMapping public ResponseEntity<HttpStatus>
	 * deleteByKey(@RequestParam("key") String key) { return
	 * licenceService.deleteByKey(key); }
	 */
}
