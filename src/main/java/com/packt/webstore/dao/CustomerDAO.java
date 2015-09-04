package com.packt.webstore.dao;

import java.util.List;

import com.packt.webstore.domain.Customer;

public interface CustomerDAO {

	List<Customer> getAllCustomers();

}
