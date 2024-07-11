package com.hsf.hsh.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "REVIEWS")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "customerID", referencedColumnName = "customerID")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "carID", referencedColumnName = "carID")
	private Car car;
	
	private int reviewStar;
	
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getReviewStar() {
		return reviewStar;
	}

	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Review(int id, Customer customer, Car car, int reviewStar, String comment) {
		super();
		this.id = id;
		this.customer = customer;
		this.car = car;
		this.reviewStar = reviewStar;
		this.comment = comment;
	}

	public Review() {
		super();
	}
	
	
}
