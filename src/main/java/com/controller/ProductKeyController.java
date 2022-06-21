package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.ProductKey;

@RestController
public class ProductKeyController {
	
	@GetMapping("/product")
	public ProductKey getProductKey() {
		ProductKey pr = new ProductKey();
		pr.setApplicationName("KMS");
		pr.setLicensekey("aaa-bbb-ccc-ddd");
		return pr;
	}

}
