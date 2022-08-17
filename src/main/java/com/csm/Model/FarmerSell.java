package com.csm.Model;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "farmer_sell_tbl")

public class FarmerSell {
	@Id
	@Column(name = "sell_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sellId;
	@ManyToOne
	@JoinColumn(name = "farmerCode", referencedColumnName = "farmerCode")
	private Farmer farmer;
	private double qty;
	private double ammount;
	private Date date;
	public int getSellId() {
		return sellId;
	}
	public void setSellId(int sellId) {
		this.sellId = sellId;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
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
		return "FarmerSell [sellId=" + sellId + ", farmer=" + farmer + ", qty=" + qty + ", ammount=" + ammount
				+ ", date=" + date + "]";
	}
	
	
}
