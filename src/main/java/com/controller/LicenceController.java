package com.controller;

import com.model.LicenceEntity;
import com.service.LicenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/licence")
public class LicenceController {

    @Autowired
    private LicenceService licenceService;

    @GetMapping
    public ResponseEntity<LicenceEntity> get(@RequestParam int id) {
        return licenceService.getById(id);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody LicenceEntity licence) {
        return licenceService.create(licence);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> update(@RequestParam int id,@RequestBody LicenceEntity licence) {
        return licenceService.update(licence);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteEmployeeById(@RequestParam("id") int id) {
        return licenceService.deleteById(id);
    }
}
