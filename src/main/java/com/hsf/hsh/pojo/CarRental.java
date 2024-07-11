package com.hsf.hsh.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.bytebuddy.utility.nullability.MaybeNull;

@Entity
@Table(name = "CARRENTALS")
public class CarRental {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int carRentalID;
	
	@ManyToOne
	@JoinColumn(name = "customerID", referencedColumnName = "customerID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "carID", referencedColumnName = "carID")
	private Car car;
	
	private Date pickupDate;
	
	private Date returnDate;
	
	private double rentPrice;
	
	private String status;

	public int getCarRentalID() {
		return carRentalID;
	}

	public void setCarRentalID(int carRentalID) {
		this.carRentalID = carRentalID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public double getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(double rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public CarRental(int carRentalID, Customer customer, Car car, Date pickupDate, Date returnDate, double rentPrice,
			String status) {
		super();
		this.carRentalID = carRentalID;
		this.customer = customer;
		this.car = car;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.rentPrice = rentPrice;
		this.status = status;
	}
	
	public CarRental(Customer customer, Car car, Date pickupDate, Date returnDate, double rentPrice,
			String status) {
		super();
		this.customer = customer;
		this.car = car;
		this.pickupDate = pickupDate;
		this.returnDate = returnDate;
		this.rentPrice = rentPrice;
		this.status = status;
	}

	public CarRental() {
		super();
	}
	
	
}
