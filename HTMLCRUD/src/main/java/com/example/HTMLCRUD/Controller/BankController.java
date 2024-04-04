package com.example.HTMLCRUD.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.HTMLCRUD.Model.AccountValid;
import com.example.HTMLCRUD.Model.AgencyAccount;
import com.example.HTMLCRUD.Model.Bank;
import com.example.HTMLCRUD.Service.BankService;

@Controller
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("BankList", bankService.readBank());
		return "home";
	}
	
	@GetMapping("/Login")
	public String Login(Model model) {
		return "login";
	}

	@PostMapping("/loginsave")
	public String saveLogin(@ModelAttribute Bank bank, Model model) {
	    String bankName = bank.getBankName();
	    String location = bank.getLocation();
	    model.addAttribute("bankName", bankName);
	    model.addAttribute("location", location);
	    System.out.println(bankName);
	    System.out.println(location);
	    Bank findBank = bankService.findnameloc(bankName, location);
	    
	    if (findBank != null && bankName.equals(findBank.getBankName()) && location.equals(findBank.getLocation())) {
	        return "logininside"; // Redirect to success page or desired view
	    } else {
	        return "redirect:/"; // Redirect back to login page or error handling view
	    }
	}


	@PostMapping("/accountdetail")
	public String Addlogin(@ModelAttribute AccountValid valid, ModelMap model) {
		String accountnumber=valid.getAccountnumber();
		String reqfile=valid.getReqfilename();
		String fromdate=valid.getFromdate();
		String todate=valid.getTodate();
	    model.addAttribute("countryName", accountnumber);
	    System.out.println(valid.getAccountnumber() + " accountnumber");
	    model.addAttribute("requestMessageId",reqfile );
	    model.addAttribute("fromDate", fromdate);
	    model.addAttribute("toDate", todate);
	    List<AgencyAccount> agencyAccounts = bankService.fetchAgencyAccounts(accountnumber,reqfile,fromdate,todate);
	    
	    // Add data to the model for rendering in the view
	    model.addAttribute("agencyAccounts", agencyAccounts);
	    
	    return "accountDetails"; 
	}

	
	
	
	@GetMapping("/AddDetails")
	public String AddDetails(Model model) {
		Bank bank=new Bank();
		model.addAttribute(bank);
		return "adddetails";
	}
	
	
	@PostMapping("/save")
	public String saveDetails(@ModelAttribute("bank")  Bank bank) {
		bankService.createBank(bank);
		return "redirect:/";
	}
	
	@GetMapping("/update/{id}")
	public String Update(@PathVariable int id, Model model) {
		Bank bank=bankService.readById(id);
		model.addAttribute(bank);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		this.bankService.delete(id);
		return "redirect:/";
	}
	
	

}
