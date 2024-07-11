package com.hsf.hsh.service;

import java.util.List;

import com.hsf.hsh.pojo.Account;
import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.Customer;
import com.hsf.hsh.repository.CarRepository;
import com.hsf.hsh.repository.CustomerRepository;
import com.hsf.hsh.repository.ICarRepository;
import com.hsf.hsh.repository.ICustomerRepository;

public class CustomerService implements ICustomerService {
	
	private ICustomerRepository iCustomerRepository = null;
	
	public CustomerService(String fileName) {
		iCustomerRepository = new CustomerRepository(fileName);
	}
	
	@Override
	public List<Customer> findAll() {
		// TODO Auto-generated method stub
		return iCustomerRepository.findAll();
	}

	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		iCustomerRepository.save(customer);
	}

	@Override
	public void delete(String customerID) {
		// TODO Auto-generated method stub
		iCustomerRepository.delete(customerID);
	}

	@Override
	public Customer findById(String customerID) {
		// TODO Auto-generated method stub
		return iCustomerRepository.findById(customerID);
	}

	@Override
	public void update(Customer customer) {
		// TODO Auto-generated method stub
		iCustomerRepository.update(customer);
	}
	
	@Override
	public Customer checkLogin(String email, String password) {
		return iCustomerRepository.checkLogin(email, password);
	}

	@Override
	public Account getAccountByID(String accountID) {
		// TODO Auto-generated method stub
		return iCustomerRepository.getAccountByID(accountID);
	}

}
