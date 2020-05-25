package com.capgemini.main.drinkanddelight.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.main.drinkanddelight.dao.ProductDaoInterface;
import com.capgemini.main.drinkanddelight.entites.StockDetails;

import com.capgemini.main.drinkanddelight.exception.ProductNotFoundException;






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
	public boolean updateProduct(String stockId, LocalDate manufactureDate, LocalDate expiryDate, String qualityCheck) throws ProductNotFoundException {
		Optional<StockDetails> optional= daoObj.findById(stockId);
		 if(optional.isPresent())
		 {
			 	StockDetails order = optional.get();
			 	if(order!=null && manufactureDate.compareTo(LocalDate.now())<0 && expiryDate.compareTo(LocalDate.now())>0 )
			 	{
			 		order.setExpiryDate(expiryDate);
			 order.setManufactureDate(manufactureDate);
			 order.setQualityCheck(qualityCheck);
			 return true;
			 	}
			 	else
			 		throw new ProductNotFoundException("sorry! we can not update it enter valid md and ed");
		 }
		return false;
	}




	@Override
	public boolean doesProductOrderIdExists(String stockId) {
		// TODO Auto-generated method stub
	Optional<StockDetails>	optional=
			daoObj.findById(stockId);
	if(optional.isPresent())
	{
		StockDetails order=optional.get();
		return true;
	}
		return false;
	}




	@Override
	public boolean setExitDate(String stockId, LocalDate exitDate) throws ProductNotFoundException {
		Optional<StockDetails> optional= daoObj.findById(stockId);
		 if(optional.isPresent())
		 {
			 	StockDetails order = optional.get();
			 	if(order !=null && exitDate.compareTo(LocalDate.now())<=0)
			 	{
			 	order.setExitDate(exitDate);
			 	return true;
			 	}
			 	else
			 	{
			 		throw new ProductNotFoundException("Exit date can not be set");
			 	}
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
