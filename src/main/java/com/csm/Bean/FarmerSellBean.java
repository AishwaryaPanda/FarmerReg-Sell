package com.csm.Bean;


import java.util.Date;


public class FarmerSellBean {
	private int sellId;
	private int farmer;
	private double qty;
	private double ammount;
	private Date date;
	
	
	public int getSellId() {
		return sellId;
	}


	public void setSellId(int sellId) {
		this.sellId = sellId;
	}


	public int getFarmer() {
		return farmer;
	}


	public void setFarmer(int farmer) {
		this.farmer = farmer;
	}


	public double getQty() {
		return qty;
	}


	public void setQty(double qty) {
		this.qty = qty;
	}


	public double getAmmount() {
		return ammount;
	}


	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "FarmerSellBean [sellId=" + sellId + ", farmer=" + farmer + ", qty=" + qty + ", ammount=" + ammount
				+ ", date=" + date + "]";
	}
	
	
}
