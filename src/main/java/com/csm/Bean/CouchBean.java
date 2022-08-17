package com.csm.Bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CouchBean {
	@JsonProperty("id")
	private String id;
	@JsonProperty("revision")
	private String revision;

	@JsonProperty("_id")
	private String _id;
	@JsonProperty("_rev")
	private String _rev;
	
	@JsonProperty("farmer_id")
	private String farmerId;

	@JsonProperty("farmer_name")
	private String farmerName;
	@JsonProperty("farmer_code")
	private String farmerCode;
	@JsonProperty("mobile")
	private String mobileNo;
	@JsonProperty("aadhaar")
	private String aadhaarNo;
	@JsonProperty("bank")
	private String bankName;
	@JsonProperty("branch")
	private String branchName;
	@JsonProperty("ifsc")
	private String ifscCode;
	@JsonProperty("account")
	private String accountNo;
	@JsonProperty("sell_id")
	private String sellId;
	@JsonProperty("sell_quantity")
	private String sellQuantity;
	@JsonProperty("sell_amount")
	private String sellAmount;
	@JsonProperty("sell_date")
	private String sellDate;
	@JsonProperty("tp_id")
	private String transitPassId;
	@JsonProperty("tp_quant")
	private String transitPassQuant;
	@JsonProperty("status")
	private String acceptanceStatus;
	@JsonProperty("tp_date")
	private String transitPassDate;
	@JsonProperty("vehicle_no")
	private String vehicleNO;
	
	public String getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(String farmerId) {
		this.farmerId = farmerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRevision() {
		return revision;
	}
	public void setRevision(String revision) {
		this.revision = revision;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String get_rev() {
		return _rev;
	}
	public void set_rev(String _rev) {
		this._rev = _rev;
	}
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}
	public String getFarmerCode() {
		return farmerCode;
	}
	public void setFarmerCode(String farmerCode) {
		this.farmerCode = farmerCode;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getAadhaarNo() {
		return aadhaarNo;
	}
	public void setAadhaarNo(String aadhaarNo) {
		this.aadhaarNo = aadhaarNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getSellId() {
		return sellId;
	}
	public void setSellId(String sellId) {
		this.sellId = sellId;
	}
	public String getSellQuantity() {
		return sellQuantity;
	}
	public void setSellQuantity(String sellQuantity) {
		this.sellQuantity = sellQuantity;
	}
	public String getSellAmount() {
		return sellAmount;
	}
	public void setSellAmount(String sellAmount) {
		this.sellAmount = sellAmount;
	}
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public String getTransitPassId() {
		return transitPassId;
	}
	public void setTransitPassId(String transitPassId) {
		this.transitPassId = transitPassId;
	}
	public String getTransitPassQuant() {
		return transitPassQuant;
	}
	public void setTransitPassQuant(String transitPassQuant) {
		this.transitPassQuant = transitPassQuant;
	}
	public String getAcceptanceStatus() {
		return acceptanceStatus;
	}
	public void setAcceptanceStatus(String acceptanceStatus) {
		this.acceptanceStatus = acceptanceStatus;
	}
	public String getTransitPassDate() {
		return transitPassDate;
	}
	public void setTransitPassDate(String transitPassDate) {
		this.transitPassDate = transitPassDate;
	}
	public String getVehicleNO() {
		return vehicleNO;
	}
	public void setVehicleNO(String vehicleNO) {
		this.vehicleNO = vehicleNO;
	}
	@Override
	public String toString() {
		return "CouchBean [id=" + id + ", revision=" + revision + ", _id=" + _id + ", _rev=" + _rev + ", farmerId="
				+ farmerId + ", farmerName=" + farmerName + ", farmerCode=" + farmerCode + ", mobileNo=" + mobileNo
				+ ", aadhaarNo=" + aadhaarNo + ", bankName=" + bankName + ", branchName=" + branchName + ", ifscCode="
				+ ifscCode + ", accountNo=" + accountNo + ", sellId=" + sellId + ", sellQuantity=" + sellQuantity
				+ ", sellAmount=" + sellAmount + ", sellDate=" + sellDate + ", transitPassId=" + transitPassId
				+ ", transitPassQuant=" + transitPassQuant + ", acceptanceStatus=" + acceptanceStatus
				+ ", transitPassDate=" + transitPassDate + ", vehicleNO=" + vehicleNO + "]";
	}
	
	
	

}
