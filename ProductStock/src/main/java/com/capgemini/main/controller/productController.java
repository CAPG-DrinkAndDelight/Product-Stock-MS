package com.capgemini.main.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capgemini.main.entites.StockDetails;
import com.capgemini.main.entites.UpdateStockDto;
import com.capgemini.main.service.ProductServiceInterface;

@RestController
@RequestMapping("/api/v1")
public class productController {
	
	
	@Autowired
	ProductServiceInterface serviceObj;

	
	
	@PostMapping("/updateProduct/{stockId}")
	public boolean updateProduct( @RequestBody UpdateStockDto details ){
		serviceObj.updateProduct(details.getStockId(),details.getManufactureDate(),details.getExpiryDate(),details.getQualityCheck());
		return true;
		
	}
//	
	
	@GetMapping("/getProductSpecs/{stockId}")
	public StockDetails getProductSpecs(@PathVariable String stockId)
	{
		return serviceObj.getProductSpecs(stockId);
	}
	
	
	
	@GetMapping("/getAllProductSpecs")
    public List<StockDetails> getProductList() {
			
			return serviceObj.retrieve();
			
	}
	
//	
//	
	
	
}
