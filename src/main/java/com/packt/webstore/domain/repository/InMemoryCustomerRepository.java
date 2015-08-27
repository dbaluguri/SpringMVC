package com.packt.webstore.domain.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Customer;

@Repository
public class InMemoryCustomerRepository implements CustomerRepository {

	private List<Customer> listOfCustomers = new ArrayList<Customer>();
	
	private InMemoryCustomerRepository() {
		Customer cust1 = new Customer();
		cust1.setCustomerId(123l);
		cust1.setAddress("500 W Madison st, Chicago, IL, 60504");
		cust1.setName("John Gresham");
		cust1.setNoOfOrdersMade(5);
		listOfCustomers.add(cust1);
		
		Customer cust2 = new Customer();
		cust2.setCustomerId(129l);
		cust2.setAddress("6400 Cooper Dr, Addison, TX, 75428");
		cust2.setName("David Shaw");
		cust2.setNoOfOrdersMade(2);
		listOfCustomers.add(cust2);
		
		Customer cust3 = new Customer();
		cust3.setCustomerId(145l);
		cust3.setAddress("1129 Dummy St, Route 59, Naperville, IL,60563");
		cust3.setName("Amiela Burny");
		cust3.setNoOfOrdersMade(6);
		listOfCustomers.add(cust3);
		
	}
	
	public List<Customer> getAllCustomers() {
		return listOfCustomers;
	}

}
