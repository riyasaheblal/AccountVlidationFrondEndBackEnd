package com.example.HTMLCRUD.Model;

public class AccountValid {

	
	private String accountnumber;
	private String reqfilename;
	private String fromdate;
	private String todate;
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getReqfilename() {
		return reqfilename;
	}
	public void setReqfilename(String reqfilename) {
		this.reqfilename = reqfilename;
	}
	public String getFromdate() {
		return fromdate;
	}
	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}
	public String getTodate() {
		return todate;
	}
	public void setTodate(String todate) {
		this.todate = todate;
	}
	public AccountValid(String accountnumber, String reqfilename, String fromdate, String todate) {
		super();
		this.accountnumber = accountnumber;
		this.reqfilename = reqfilename;
		this.fromdate = fromdate;
		this.todate = todate;
	}
	public AccountValid() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AccountValid [accountnumber=" + accountnumber + ", reqfilename=" + reqfilename + ", fromdate="
				+ fromdate + ", todate=" + todate + "]";
	}
	
	
}
