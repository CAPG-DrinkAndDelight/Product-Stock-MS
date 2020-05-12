package com.capgemini.main.entites;

import java.time.LocalDate;

public class UpdateStockDto {
	private String stockId;
	private LocalDate manufactureDate;
	private LocalDate expiryDate;
	private String qualityCheck;
	public UpdateStockDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UpdateStockDto(String stockId, LocalDate manufactureDate, LocalDate expiryDate, String qualityCheck) {
		super();
		this.stockId = stockId;
		this.manufactureDate = manufactureDate;
		this.expiryDate = expiryDate;
		this.qualityCheck = qualityCheck;
	}
	@Override
	public String toString() {
		return "UpdateStockDto [stockId=" + stockId + ", manufactureDate=" + manufactureDate + ", expiryDate="
				+ expiryDate + ", qualityCheck=" + qualityCheck + "]";
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public LocalDate getManufactureDate() {
		return manufactureDate;
	}
	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getQualityCheck() {
		return qualityCheck;
	}
	public void setQualityCheck(String qualityCheck) {
		this.qualityCheck = qualityCheck;
	}
	
}
