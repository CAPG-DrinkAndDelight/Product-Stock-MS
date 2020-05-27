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
	public StockDetails getProductSpecs(String stockId) throws ProductNotFoundException {
		
			 Optional<StockDetails> detail= daoObj.findById(stockId);
			 if(detail.isPresent())
			 {
				 StockDetails stock=detail.get();
				 return stock;
			 }
			  
				 throw new ProductNotFoundException("Enter valid Stock Id");
			 
		
			
		
	}
	
	

	
	@Override
	public List<StockDetails> retrieve() throws ProductNotFoundException {
		
	List<StockDetails> list=
				daoObj.findAll();
	if(list != null)
	{
	return list;
	}
	throw new ProductNotFoundException("No Stock available in Product Stock ,please enter values");
		
	}
//
//
//
//




	@Override
	public String updateProduct(String stockId, LocalDate manufactureDate, LocalDate expiryDate, String qualityCheck) throws ProductNotFoundException {
		try {
		Optional<StockDetails> optional= daoObj.findById(stockId);
		 if(optional.isPresent())
		 {
			 	StockDetails order = optional.get();
			 	if(order!=null && manufactureDate.compareTo(LocalDate.now())<0 && expiryDate.compareTo(LocalDate.now())>0 && qualityCheck !=null )
			 	{
			 		order.setExpiryDate(expiryDate);
			 order.setManufactureDate(manufactureDate);
			 order.setQualityCheck(qualityCheck);
			 return "Product Stock Updated Successfully";
			 	}
			 	else
			 	{
			 		return "Enter valid Manufacturing Date and Expiry Date";
			 	}
			 	
		 }
		 else
		 throw new ProductNotFoundException("Enter valid Stock id");
		 
		}
		catch(ProductNotFoundException e)
		{
			throw new ProductNotFoundException("Enter valid Stock id");
		}
	
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
	public String setExitDate(String stockId, LocalDate exitDate) throws ProductNotFoundException  {
		try {
		Optional<StockDetails> optional= daoObj.findById(stockId);
		 if(optional.isPresent())
		 {
			 	StockDetails order = optional.get();
			 	if(order !=null && exitDate.compareTo(LocalDate.now())<=0)
			 	{
			 	order.setExitDate(exitDate);
			 	return "exit date set";
			 	}
			 	
			 		return "enter valid exit date";
			 	
		 }
		
		 throw new ProductNotFoundException("Enter valid Stock Id");
		}
		catch(ProductNotFoundException e)
		{
			 throw new ProductNotFoundException("Enter valid Stock Id");
		}
		
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
