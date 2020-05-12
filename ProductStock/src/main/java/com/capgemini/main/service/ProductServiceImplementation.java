package com.capgemini.main.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.dao.ProductDaoInterface;

import com.capgemini.main.entites.StockDetails;






@Service
@Transactional
public class ProductServiceImplementation implements ProductServiceInterface{

	@Autowired
	ProductDaoInterface daoObj;

	@Override
	public StockDetails getProductSpecs(String stockId) {
		  
			 return daoObj.findById(stockId).get();
			
	}
	
	

	
	@Override
	public List<StockDetails> retrieve() {
		
		return (List<StockDetails>)
				daoObj.findAll();
	}
//
//
//
//




	@Override
	public boolean updateProduct(String stockId, LocalDate manufactureDate, LocalDate expiryDate, String qualityCheck) {
		Optional<StockDetails> optional= daoObj.findById(stockId);
		 if(optional.isPresent())
		 {
			 	StockDetails order = optional.get();
			 order.setExpiryDate(expiryDate);
			 order.setManufactureDate(manufactureDate);
			 order.setQualityCheck(qualityCheck);
			 return true;
		 }
		return false;
	}



//
//	@Override
//	public boolean updateProduct(StockDetails details) {
//		java.util.Optional<StockDetails> find=daoObj.findById(details.getStockId());
//		if(find.isPresent())
//		{
//			 daoObj.save(details);
//			 return true;
//
//		}
//			return false;
//	}




	










	




	
	
	

}
