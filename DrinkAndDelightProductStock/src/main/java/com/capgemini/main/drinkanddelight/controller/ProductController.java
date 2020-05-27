package com.capgemini.main.drinkanddelight.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.main.drinkanddelight.entites.StockDetails;
import com.capgemini.main.drinkanddelight.entites.UpdateStockDto;
import com.capgemini.main.drinkanddelight.exception.ProductNotFoundException;
import com.capgemini.main.drinkanddelight.service.ProductServiceInterface;



@RestController
@RequestMapping("/productstock")
@CrossOrigin(origins="*")
public class ProductController {
//
//	private static final Logger logger = Logger.getLogger(productController.class);
	@Autowired
	ProductServiceInterface serviceObj;

	
	
	@PostMapping("/updateProduct/{stockId}")
	public String updateProduct( @RequestBody UpdateStockDto details ) throws ProductNotFoundException{
		
		return serviceObj.updateProduct(details.getStockId(),details.getManufactureDate(),details.getExpiryDate(),details.getQualityCheck());
		
		
	}
//	
	
	@GetMapping("/getProductSpecs/{stockId}")
	public StockDetails getProductSpecs(@PathVariable String stockId) throws ProductNotFoundException 
	{
		
		
		return serviceObj.getProductSpecs(stockId);
				
		}
		
	
	
	
	
	@GetMapping("/getAllProductSpecs") 
    public List<StockDetails> getProductList() throws ProductNotFoundException {
			
			List<StockDetails> list=serviceObj.retrieve();
			return list;
			
		
		//return serviceObj.retrieve();
			
	}
	@GetMapping("/doesOrderIdPresent/{stockId}")
	public boolean doesProductOrderIdExists(@PathVariable String stockId)
	{
//		 if(stockId==null)
//		 {
//			 throw new NullParameterException("Null request, please provide valid stockid!");
//		 }
		serviceObj.doesProductOrderIdExists(stockId);
		return true;
		
	}
	@PostMapping("/setexitdate/{stockId}")
	public String setExitDate(@RequestBody StockDetails stock) throws ProductNotFoundException
	{
		
		return serviceObj.setExitDate(stock.getStockId(),stock.getExitDate());
		
	}
	
//	
//	
	
	
}
