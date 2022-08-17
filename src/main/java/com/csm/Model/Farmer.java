package com.csm.Model;



import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "farmer_tbl")

public class Farmer implements Serializable{
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String farmerCode;
	private String mobile;
	private String aadhar;
	private String bankName;
	private String ifscCode;
	private String accountNumber;
	private String branch;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFarmerCode() {
		return farmerCode;
	}
	public void setFarmerCode(String farmerCode) {
		this.farmerCode = farmerCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Farmer [id=" + id + ", name=" + name + ", farmerCode=" + farmerCode + ", mobile=" + mobile + ", aadhar="
				+ aadhar + ", bankName=" + bankName + ", ifscCode=" + ifscCode + ", accountNumber=" + accountNumber
				+ ", branch=" + branch + "]";
	}
	
	
	
}


