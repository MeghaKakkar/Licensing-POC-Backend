package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LicenseController {
	
	@GetMapping
	public String helloWorld() {
		return "hello-world";
	}

}