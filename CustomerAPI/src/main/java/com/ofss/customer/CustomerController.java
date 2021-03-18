package com.ofss.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ofss.services.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping("/customers")
	public List<Customer> getAllCustomers()
	{
		return customerService.getAllCustomers();
	}
	
	@RequestMapping("/customers/{name}")
	public Customer getCustomer(@PathVariable("name") String myname)
	{
		return customerService.getCustomer(myname);
	}
	
	@RequestMapping(value="/customers", method=RequestMethod.POST)
	public void addCustomer(@RequestBody Customer cust)
	{
		customerService.addCustomer(cust);
	}

	@RequestMapping(value="/customers/{name}", method=RequestMethod.PUT)
	public void updateCustomer(@RequestBody Customer cust, @PathVariable("name") String customerName)
	{
		System.out.println("Update method controller");
		System.out.println("customer name is "+customerName);
		
		customerService.updateCustomer(customerName, cust);
	}	

	@RequestMapping(value="/customers/{name}", method=RequestMethod.DELETE)
	public void deleteCustomer(@PathVariable("name") String customerName)
	{
		System.out.println("DELETE method controller");
		System.out.println("customer name is "+customerName);
		
		customerService.deleteCustomer(customerName);
	}	
	
	// Implement this method
	public void deleteAllCustomers()
	{
		
	}

}
