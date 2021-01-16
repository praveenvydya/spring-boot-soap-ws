package com.javalines.spring.soap.api.endpoint;

 
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.javalines.spring.soap.api.customerservice.Customer;
import com.javalines.spring.soap.api.customerservice.GetAllCustomersRequest;
import com.javalines.spring.soap.api.customerservice.GetCustomerRequest;
import com.javalines.spring.soap.api.customerservice.ResponseCustomer;
import com.javalines.spring.soap.api.customerservice.ResponseCustomers;

@Endpoint
public class CustomerServiceIndicatorEndPoint {

	
	private static final String NAMESPACE_URI = "http://www.javalines.com/spring/soap/api/customerService";
	
	//@Autowired
	//private LoanEligibilityService service;
	
	
	/*
	 * @PayloadRoot(namespace=NAMESPACE,localPart="CustomerRequest")
	 * 
	 * @ResponsePayload public Acknowledgement getLoanStatus (@RequestPayload GetCu
	 * req) { return service.checkLoanEligibility(req); }
	 */
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCustomerRequest")
	@ResponsePayload
	public ResponseCustomer getCustomer(@RequestPayload GetCustomerRequest request,MessageContext messageContext) {
		ResponseCustomer ret = new ResponseCustomer();
		ret.setId(101);
		ret.setName("Amir");
		ret.setAge(32);
		return ret;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetAllCustomersRequest")
	@ResponsePayload
	public ResponseCustomers getAllCustomers(@RequestPayload GetAllCustomersRequest req) {
		ResponseCustomers ret =  new ResponseCustomers();
		 
		ret.setCount(1);
		ret.setStatus(true);
		Customer cust = new Customer();
		cust.setId(101);
		cust.setName("Amir");
		cust.setAge(32);
		
		ret.getCustomerItems().add(cust);
		
		return ret;
		
	}
}
