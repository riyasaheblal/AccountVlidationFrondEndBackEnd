package com.example.HTMLCRUD.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.HTMLCRUD.Model.AgencyAccount;
import com.example.HTMLCRUD.Model.Bank;
import com.example.HTMLCRUD.Repository.BankRepository;

@Service
public class BankServiceImpl implements BankService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private BankRepository bankRepository;

	@Override
	public Bank createBank(Bank bank) {
		return this.bankRepository.save(bank);
	}

	@Override
	public List<Bank> readBank() {
		return this.bankRepository.findAll();
	}


   public Bank findnameloc(String name,String location) {
	   
	   return bankRepository.findByBankNameAndLocation(name, location);
   }

	@Override
	public List<AgencyAccount> fetchAgencyAccounts(String accountnumber, String reqfile, String fromdate, String todate) {
		String sql = "SELECT REQUESTMESSAGEID, ACCOUNTNUMBER, AGENCYNAME ACCOUNTHOLDRNAME, " +
				"DECODE(TRIM(VALIDATIONRESULT),'I','INVALID','V','VALID','N','NA',TRIM(VALIDATIONRESULT)) VALIDATIONSTATUS, " +
				"DECODE(TRIM(ACCOUNTVALIDSTATUS),'A','ACTIVE','C','CLOSE','N','NA',TRIM(ACCOUNTVALIDSTATUS)) ACCOUNTSTATUS, " +
				"TO_CHAR(CREATEDDATE,'DD-MM-YYYY HH24:MI:SS') CREATEDDATE, QUICKRESPONSEMESSAGEID RESPONSEMESSAGEID " +
				"FROM agencyaccountmaster " +
				"WHERE " +
				"REQUESTMESSAGEID = ?";

		System.out.println(sql);
		return jdbcTemplate.query(sql, new Object[]{reqfile}, (rs, rowNum) -> {
			AgencyAccount account = new AgencyAccount();
			account.setRequestMessageId(rs.getString("REQUESTMESSAGEID"));
			account.setAccountNumber(rs.getString("ACCOUNTNUMBER"));
			account.setAgencyName(rs.getString("ACCOUNTHOLDRNAME")); // Use alias or column name
			account.setValidationStatus(rs.getString("VALIDATIONSTATUS")); // Use alias or column name
			account.setAccountStatus(rs.getString("ACCOUNTSTATUS")); // Use alias or column name
			account.setCreatedDate(rs.getString("CREATEDDATE"));
			account.setResponseMessageId(rs.getString("RESPONSEMESSAGEID"));

			System.out.println("done");
			return account;
		});
	}
	
	
	
//	@Override
//	public List<AgencyAccount> fetchAgencyAccounts(String accountnumber, String reqfile, String fromdate, String todate) {
//	    String sql = "SELECT REQUESTMESSAGEID, ACCOUNTNUMBER, AGENCYNAME ACCOUNTHOLDRNAME, " +
//	            "DECODE(TRIM(VALIDATIONRESULT),'I','INVALID','V','VALID','N','NA',TRIM(VALIDATIONRESULT)) VALIDATIONSTATUS, " +
//	            "DECODE(TRIM(ACCOUNTVALIDSTATUS),'A','ACTIVE','C','CLOSE','N','NA',TRIM(ACCOUNTVALIDSTATUS)) ACCOUNTSTATUS, " +
//	            "TO_CHAR(CREATEDDATE,'DD-MM-YYYY HH24:MI:SS') CREATEDDATE, QUICKRESPONSEMESSAGEID RESPONSEMESSAGEID " +
//	            "FROM agencyaccountmaster " +
//	            "WHERE REQUESTMESSAGEID = ? and ACCOUNTNUMBER = LPAD(TRIM(?), 17, '0') ";
//
//	    System.out.println(sql);
//	    return jdbcTemplate.query(sql, new Object[]{reqfile,accountnumber}, (rs, rowNum) -> {
//	        AgencyAccount account = new AgencyAccount();
//	        account.setRequestMessageId(rs.getString("REQUESTMESSAGEID"));
//	        account.setAccountNumber(rs.getString("ACCOUNTNUMBER"));
//	        account.setAgencyName(rs.getString("ACCOUNTHOLDRNAME")); // Use alias or column name
//	        account.setValidationStatus(rs.getString("VALIDATIONSTATUS")); // Use alias or column name
//	        account.setAccountStatus(rs.getString("ACCOUNTSTATUS")); // Use alias or column name
//	        account.setCreatedDate(rs.getString("CREATEDDATE"));
//	        account.setResponseMessageId(rs.getString("RESPONSEMESSAGEID"));
//
//	        System.out.println("done");
//	        return account;
//	    });
//	}






	@Override
	public Bank findbynameamdlocation(Bank bank) {
		return bankRepository.findByBankNameAndLocation(bank.getBankName(), bank.getLocation());

	}

	@Override
	public Bank readById(int id) {
		Optional<Bank> optional=bankRepository.findById(id);
		Bank bank=null;
		if(optional.isPresent()) {
			bank=optional.get();	
		}
		return bank;
	}

	@Override
	public void delete(int id) {
		this.bankRepository.deleteById(id);		
	}


}
