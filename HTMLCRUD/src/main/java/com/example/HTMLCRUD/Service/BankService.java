package com.example.HTMLCRUD.Service;

import java.util.List;

import com.example.HTMLCRUD.Model.AgencyAccount;
import com.example.HTMLCRUD.Model.Bank;

public interface BankService {

	
	public Bank createBank(Bank bank);
	public List<Bank> readBank();
	public Bank readById(int id);
	public void delete(int id);
	Bank findbynameamdlocation(Bank bank);
	public List<AgencyAccount> fetchAgencyAccounts(String accountnumber, String reqfile, String fromdate, String todate);
	Bank findnameloc(String name, String location);
	
}
