package com.hsf.hsh.repository;

import java.util.List;

import com.hsf.hsh.dao.CarDAO;
import com.hsf.hsh.dao.CustomerDAO;
import com.hsf.hsh.pojo.Account;
import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.Customer;

public class CustomerRepository implements ICustomerRepository {
	
	private static CustomerDAO customerDAO = null;

	public CustomerRepository(String persistanceName) {
		if(customerDAO == null) {
			customerDAO = new CustomerDAO(persistanceName);
		}
	}

	@Override
	public List<Customer> findAll() {
		return customerDAO.getCustomers();
	}
	
	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);
	}
	
	@Override
	public void delete(String customerID) {
		customerDAO.delete(customerID);
	}
	
	@Override
	public Customer findById(String customerID) {
		return customerDAO.findById(customerID);
	}
	
	@Override
	public void update(Customer customer) {
		customerDAO.update(customer);
	}
	
	@Override
	public Customer checkLogin(String email, String password) {
		Customer customer = customerDAO.checkLogin(email, password);
		if(customer != null) {
			return customer;
		}
		return null;
	}

	@Override
	public Account getAccountByID(String accountID) {
		// TODO Auto-generated method stub
		return customerDAO.findAccountById(accountID);
	}

}
