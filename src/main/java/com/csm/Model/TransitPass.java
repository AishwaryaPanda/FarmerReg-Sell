package com.csm.Model;



import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "transit_pass_tbl")

public class TransitPass {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transId;
	@ManyToOne
	@JoinColumn(name = "sell_Id")
	private FarmerSell farmerSell;
	@ManyToOne
	@JoinColumn(name = "farmerCode", referencedColumnName = "farmerCode")
	private Farmer farmer;
	private double transQty;
	private int transStatus;
	private Date date;
	private String vehicleNo;
	public int getTransId() {
		return transId;
	}
	public void setTransId(int transId) {
		this.transId = transId;
	}
	public FarmerSell getFarmerSell() {
		return farmerSell;
	}
	public void setFarmerSell(FarmerSell farmerSell) {
		this.farmerSell = farmerSell;
	}
	public Farmer getFarmer() {
		return farmer;
	}
	public void setFarmer(Farmer farmer) {
		this.farmer = farmer;
	}
	public double getTransQty() {
		return transQty;
	}
	public void setTransQty(double transQty) {
		this.transQty = transQty;
	}
	public int getTransStatus() {
		return transStatus;
	}
	public void setTransStatus(int transStatus) {
		this.transStatus = transStatus;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	@Override
	public String toString() {
		return "TransitPass [transId=" + transId + ", farmerSell=" + farmerSell + ", farmer=" + farmer + ", transQty="
				+ transQty + ", transStatus=" + transStatus + ", date=" + date + ", vehicleNo=" + vehicleNo + "]";
	}
	
	
}
