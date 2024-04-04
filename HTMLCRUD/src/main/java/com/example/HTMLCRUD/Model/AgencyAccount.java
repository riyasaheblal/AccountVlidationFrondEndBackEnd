package com.example.HTMLCRUD.Model;

public class AgencyAccount {
	private String requestMessageId;
    private String accountNumber;
    private String agencyName;
    private String validationStatus;
    private String accountStatus;
    private String createdDate;
    private String responseMessageId;
	public String getRequestMessageId() {
		return requestMessageId;
	}
	public void setRequestMessageId(String requestMessageId) {
		this.requestMessageId = requestMessageId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getValidationStatus() {
		return validationStatus;
	}
	public void setValidationStatus(String validationStatus) {
		this.validationStatus = validationStatus;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getResponseMessageId() {
		return responseMessageId;
	}
	public void setResponseMessageId(String responseMessageId) {
		this.responseMessageId = responseMessageId;
	}
	public AgencyAccount(String requestMessageId, String accountNumber, String agencyName, String validationStatus,
			String accountStatus, String createdDate, String responseMessageId) {
		super();
		this.requestMessageId = requestMessageId;
		this.accountNumber = accountNumber;
		this.agencyName = agencyName;
		this.validationStatus = validationStatus;
		this.accountStatus = accountStatus;
		this.createdDate = createdDate;
		this.responseMessageId = responseMessageId;
	}
	public AgencyAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
    
}
