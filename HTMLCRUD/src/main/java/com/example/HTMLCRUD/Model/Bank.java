package com.example.HTMLCRUD.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="banktest")
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String bankName;
	private String location;
	private int IFSC;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getIFSC() {
		return IFSC;
	}
	public void setIFSC(int iFSC) {
		IFSC = iFSC;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", bankName=" + bankName + ", location=" + location + ", IFSC=" + IFSC + "]";
	}
	public Bank(int id, String bankName, String location, int iFSC) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.location = location;
		IFSC = iFSC;
	}
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
