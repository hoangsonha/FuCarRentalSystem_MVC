package com.hsf.hsh.service;

import java.util.List;

import com.hsf.hsh.pojo.Account;
import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.Customer;

public interface ICustomerService {
	public List<Customer> findAll();
	public void save(Customer customer);
	public void delete(String customerID);
	public Customer findById(String customerID);
	public void update(Customer customer);
	public Customer checkLogin(String email, String password);
	public Account getAccountByID(String accountID);
}
