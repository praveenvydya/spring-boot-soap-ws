package com.javalines.spring.soap.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javalines.spring.soap.api.loaneligibility.Acknowledgement;
import com.javalines.spring.soap.api.loaneligibility.CustomerRequest;

@Service
public class LoanEligibilityService {
	
	public Acknowledgement checkLoanEligibility(CustomerRequest req) {
		Acknowledgement ack = new Acknowledgement();
		List<String> criterias = ack.getCriteriaMismatch();
		
		if(!(req.getAge()>=30 || req.getAge()<=60)) {
			criterias.add("Age should be in between 30 and 60");
		}
		if(req.getYearlyIncome()<300000) {
			criterias.add("Income be more than Rs.3,00,000");
		}
		if(req.getCibilScore()<500) {
			criterias.add("Low cibil score. Please try after 3 months");
		}
		
		if(criterias.size()>0) {
			ack.setIsEligible(false);
			ack.setApprovedAmount(0);
		}
		else {
			ack.setIsEligible(true);
			ack.setApprovedAmount(500000);
			criterias.clear();
		}
		return ack;
		
	}

}
