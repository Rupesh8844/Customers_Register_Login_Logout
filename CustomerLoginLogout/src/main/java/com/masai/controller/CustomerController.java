package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.CurrentUserSession;
import com.masai.model.Customer;
import com.masai.model.CustomerDTO;
import com.masai.service.CustomerLoginService;



@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerLoginService customerLoginService;
	
	
	@PostMapping("/register")
	public Customer registerCustomerHandler(@RequestBody Customer customer) {
		return customerLoginService.registerCustomer(customer);
	}
	
	
	@PostMapping("/login")
	public CurrentUserSession logInCustomerHandlre(@Valid @RequestBody CustomerDTO customerDTO ) {
		
		return customerLoginService.logIntoAccount(customerDTO);
		
	}
	
	@PatchMapping("/logout")
	public String logOutCusomerHandeler(@RequestParam(required = false) String key) {
		
	 return	customerLoginService.logOutFromAccount(key);
		
	}
	
}
