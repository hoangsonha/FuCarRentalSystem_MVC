package com.hsf.hsh.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
	@Id
	private String customerID;
	private String customerName;
	private String mobile;
	private Date birthday;
	private String identityCard;
	private int licenceNumber;
	private Date licenceDate;
	private String email;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "accountID", referencedColumnName = "accountID")
	private Account account;
	
	@OneToMany(mappedBy = "customer")
	private List<CarRental> listCarRental = new ArrayList<CarRental>();

	@OneToMany(mappedBy = "customer")
	private List<Review> listReviews = new ArrayList<Review>();

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public int getLicenceNumber() {
		return licenceNumber;
	}

	public void setLicenceNumber(int licenceNumber) {
		this.licenceNumber = licenceNumber;
	}

	public Date getLicenceDate() {
		return licenceDate;
	}

	public void setLicenceDate(Date licenceDate) {
		this.licenceDate = licenceDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<CarRental> getListCarRental() {
		return listCarRental;
	}

	public void setListCarRental(List<CarRental> listCarRental) {
		this.listCarRental = listCarRental;
	}

	public List<Review> getListReviews() {
		return listReviews;
	}

	public void setListReviews(List<Review> listReviews) {
		this.listReviews = listReviews;
	}

	public Customer(String customerID, String customerName, String mobile, Date birthday, String identityCard,
			int licenceNumber, Date licenceDate, String email, String password, Account account,
			List<CarRental> listCarRental, List<Review> listReviews) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.mobile = mobile;
		this.birthday = birthday;
		this.identityCard = identityCard;
		this.licenceNumber = licenceNumber;
		this.licenceDate = licenceDate;
		this.email = email;
		this.password = password;
		this.account = account;
		this.listCarRental = listCarRental;
		this.listReviews = listReviews;
	}
	
	public Customer(String customerID, String customerName, String mobile, Date birthday, String identityCard,
			int licenceNumber, Date licenceDate, String email, String password, Account account) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.mobile = mobile;
		this.birthday = birthday;
		this.identityCard = identityCard;
		this.licenceNumber = licenceNumber;
		this.licenceDate = licenceDate;
		this.email = email;
		this.password = password;
		this.account = account;
	}

	public Customer() {
		super();
	}
	
	
}
