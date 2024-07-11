package com.hsf.hsh.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
public class Car {
	@Id
	private String carID;
	private String carName;
	private String carModelYear;
	private String color;
	private String capacity;
	private String description;
	private Date importDate;
	@ManyToOne
	@JoinColumn(name = "producerID", referencedColumnName = "producerID")
	private CarProducer producerID;
	private double rentPrice;
	private String status;
	
	@OneToMany(mappedBy = "car")
	private List<CarRental> listCarRental = new ArrayList<CarRental>(); 
	
	@OneToMany(mappedBy = "car")
	private List<Review> listReviews = new ArrayList<Review>(); 
	
	
	public String getCarID() {
		return carID;
	}
	public void setCarID(String carID) {
		this.carID = carID;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarModelYear() {
		return carModelYear;
	}
	public void setCarModelYear(String carModelYear) {
		this.carModelYear = carModelYear;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getImportDate() {
		return importDate;
	}
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}
	public CarProducer getProducerID() {
		return producerID;
	}
	public void setCarProducerID(CarProducer producerID) {
		this.producerID = producerID;
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
	
	public Car(String carID, String carName, String carModelYear, String color, String capacity, String description,
			Date importDate, CarProducer producerID, double rentPrice, String status, List<CarRental> listCarRental,
			List<Review> listReviews) {
		super();
		this.carID = carID;
		this.carName = carName;
		this.carModelYear = carModelYear;
		this.color = color;
		this.capacity = capacity;
		this.description = description;
		this.importDate = importDate;
		this.producerID = producerID;
		this.rentPrice = rentPrice;
		this.status = status;
		this.listCarRental = listCarRental;
		this.listReviews = listReviews;
	}
	
	public Car(String carID, String carName, String carModelYear, String color, String capacity, String description,
			Date importDate, CarProducer producerID, double rentPrice, String status) {
		super();
		this.carID = carID;
		this.carName = carName;
		this.carModelYear = carModelYear;
		this.color = color;
		this.capacity = capacity;
		this.description = description;
		this.importDate = importDate;
		this.producerID = producerID;
		this.rentPrice = rentPrice;
		this.status = status;
	}
	
	public Car() {
		super();
	}
	
	
	
}
