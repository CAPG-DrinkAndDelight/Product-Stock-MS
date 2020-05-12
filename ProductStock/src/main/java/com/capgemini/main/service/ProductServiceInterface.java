package com.capgemini.main.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import com.capgemini.main.entites.StockDetails;

public interface ProductServiceInterface {
	
	
	public StockDetails getProductSpecs(String stockId);

	
	public List<StockDetails> retrieve();
//
//
	public boolean updateProduct(String stockId,LocalDate  manufactureDate,LocalDate expiryDate,String qualityCheck );
//	

	
}

