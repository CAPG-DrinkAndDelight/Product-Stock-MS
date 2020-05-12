package com.capgemini.main.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.main.entites.StockDetails;

@Repository
public interface ProductDaoInterface extends JpaRepository<StockDetails,String>{
	

	
	

	

	

}
