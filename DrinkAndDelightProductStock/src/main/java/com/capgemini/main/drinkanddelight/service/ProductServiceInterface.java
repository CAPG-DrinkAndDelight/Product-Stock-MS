package com.capgemini.main.drinkanddelight.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.capgemini.main.drinkanddelight.entites.StockDetails;
import com.capgemini.main.drinkanddelight.exception.ProductNotFoundException;

public interface ProductServiceInterface {
	
	
	public StockDetails getProductSpecs(String stockId) throws ProductNotFoundException;

	
	public List<StockDetails> retrieve() throws ProductNotFoundException;
//
//
	public String updateProduct(String stockId,LocalDate  manufactureDate,LocalDate expiryDate,String qualityCheck ) throws ProductNotFoundException;
//	
	public boolean   doesProductOrderIdExists(String stockId);
	
	public String setExitDate(String stockId,LocalDate exitDate) throws ProductNotFoundException;
   
	
}

