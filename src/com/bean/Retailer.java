package com.bean;

import java.util.Date;

public class Retailer {
	private int retailerId;
	private String retailName;
	private String retailContact1;
	private String retailContact2;
	private String retailAddress1;
	private String retailAddress2;
	private int retailZip;
	private String retailCity;
	private String retailState;
	private int boxLimit;
	private int creditLimit;
	private int retailCommission;
	private int retailServiceCharge;
	private int retailInventId;
	private Date retailCreationDate;
	private int inventCost;
	
	
	public int getRetailerId() {
		return retailerId;
	}
	public void setRetailerId(int retailerId) {
		this.retailerId = retailerId;
	}
	public String getRetailName() {
		return retailName;
	}
	public void setRetailName(String retailName) {
		this.retailName = retailName;
	}
	public String getRetailContact1() {
		return retailContact1;
	}
	public void setRetailContact1(String retailContact1) {
		this.retailContact1 = retailContact1;
	}
	public String getRetailContact2() {
		return retailContact2;
	}
	public void setRetailContact2(String retailContact2) {
		this.retailContact2 = retailContact2;
	}
	
	public String getRetailAddress1() {
		return retailAddress1;
	}
	public void setRetailAddress1(String retailAddress1) {
		this.retailAddress1 = retailAddress1;
	}
	public String getRetailAddress2() {
		return retailAddress2;
	}
	public void setRetailAddress2(String retailAddress2) {
		this.retailAddress2 = retailAddress2;
	}
	public int getRetailZip() {
		return retailZip;
	}
	public void setRetailZip(int retailZip) {
		this.retailZip = retailZip;
	}
	public String getRetailCity() {
		return retailCity;
	}
	public void setRetailCity(String retailCity) {
		this.retailCity = retailCity;
	}
	public String getRetailState() {
		return retailState;
	}
	public void setRetailState(String retailState) {
		this.retailState = retailState;
	}
	public int getBoxLimit() {
		return boxLimit;
	}
	public void setBoxLimit(int boxLimit) {
		this.boxLimit = boxLimit;
	}
	public int getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(int creditLimit) {
		this.creditLimit = creditLimit;
	}
	public int getRetailCommission() {
		return retailCommission;
	}
	public void setRetailCommission(int retailCommission) {
		this.retailCommission = retailCommission;
	}
	public int getRetailServiceCharge() {
		return retailServiceCharge;
	}
	public void setRetailServiceCharge(int retailServiceCharge) {
		this.retailServiceCharge = retailServiceCharge;
	}
	public int getRetailInventId() {
		return retailInventId;
	}
	public void setRetailInventId(int retailInventId) {
		this.retailInventId = retailInventId;
	}
	public Date getRetailCreationDate() {
		return retailCreationDate;
	}
	public void setRetailCreationDate(Date retailCreationDate) {
		this.retailCreationDate = retailCreationDate;
	}
	public int getInventCost() {
		return inventCost;
	}
	public void setInventCost(int inventCost) {
		this.inventCost = inventCost;
	}
	
	@Override
	public String toString() {
		return "Retailer [retailerId=" + retailerId + ", retailName=" + retailName + ", retailContact1="
				+ retailContact1 + ", retailContact2=" + retailContact2 + ", retailAddress1=" + retailAddress1
				+ ", retailAddress2=" + retailAddress2 + ", retailZip=" + retailZip + ", retailCity=" + retailCity
				+ ", retailState=" + retailState + ", boxLimit=" + boxLimit + ", creditLimit=" + creditLimit
				+ ", retailCommission=" + retailCommission + ", retailServiceCharge=" + retailServiceCharge
				+ ", retailInventId=" + retailInventId + ", retailCreationDate=" + retailCreationDate + ", inventCost="
				+ inventCost + "]";
	}
}
