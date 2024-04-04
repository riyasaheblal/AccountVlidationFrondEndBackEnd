package com.example.HTMLCRUD.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.HTMLCRUD.Model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
	Bank findByBankNameAndLocation(String bankName, String location);

}
