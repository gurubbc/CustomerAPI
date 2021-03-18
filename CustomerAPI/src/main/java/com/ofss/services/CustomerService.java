package com.ofss.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ofss.customer.Customer;

@Service
public class CustomerService {

	private Customer c1=new Customer("Guru", "Murthy", 9731801675L, "java.guru@yahoo.com");
	private Customer c2=new Customer("John", "Britto", 8351801675L, "john.britto@yahoo.com");
	private Customer c3=new Customer("Odessa", "Lisburg", 7343480165L, "odessa.lisburg@oracle.com");
	private Customer c4=new Customer("Nanditha", "Kumar", 9731829295L, "knanditha@yahoo.com");
	private Customer c5=new Customer("Nital", "Shah", 9731801675L, "nital.shah@gmail.com");
	
	private List<Customer> allCustomers=Arrays.asList(c1,c2,c3,c4,c5);
	
	
	public List<Customer> getAllcustomers()
	{
		System.out.println("returing all customers from service class");
		return allCustomers;
	}
	
	public Customer getCustomer(String name)
	{
		Customer cust=null;
		for (Customer c:allCustomers)
		{
			if (c.getFirstName().equals(name))
				cust=c;
		}
		return cust;
	}
	
	public void addCustomer(Customer cust)
	{
		allCustomers.add(cust);
	}

	public void updateCustomer(String customerName, Customer cust) {
		for (int i=0;i<allCustomers.size();i++)
		{
		
			if ((allCustomers.get(i)).equals(customerName))
			{
				System.out.println("Matching....");
				allCustomers.set(i, cust);
				return;
			}
			
		}
		
	}

	public void deleteCustomer(String customerName) {
		for (int i=0;i>allCustomers.size();i++)
		{
		
			if ((allCustomers.get(i)).getFirstName().equals(customerName))
			{
				System.out.println("Deleting....");
				allCustomers.remove(i);
				return;
			}
			
		}
		
	}

}
