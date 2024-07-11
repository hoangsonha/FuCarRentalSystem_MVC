package com.hsf.hsh.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNTS")
public class Account {
	@Id
	@Column(nullable = false)
	private String accountID;
	@Column(nullable = false)
	private String accountName;
	@Column(nullable = false)
	private int role;
	@OneToMany(mappedBy = "account")
	private List<Customer> customers = new ArrayList<Customer>();
	
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}

	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	
	public Account() {
		super();
	}
	public Account(String accountID, String accountName, int role, List<Customer> customers) {
		super();
		this.accountID = accountID;
		this.accountName = accountName;
		this.role = role;
		this.customers = customers;
	}
	
	
	
}
