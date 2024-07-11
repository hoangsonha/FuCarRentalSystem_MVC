package com.hsf.hsh.pojo;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "CARPRODUCERS")
public class CarProducer {
	@Id
	@Column(nullable = false)
	private String producerID;
	@Column(nullable = false)
	private String procuderName;
	@Column(nullable = false)
	private String address;
	@Column(nullable = false)
	private String country;
	@OneToMany(mappedBy = "producerID")
	private List<Car> setCars = new ArrayList<Car>();
	public String getProducerID() {
		return producerID;
	}
	public void setProducerID(String producerID) {
		this.producerID = producerID;
	}
	public String getProcuderName() {
		return procuderName;
	}
	public void setProcuderName(String procuderName) {
		this.procuderName = procuderName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<Car> getSetCars() {
		return setCars;
	}
	public void setSetCars(List<Car> setCars) {
		this.setCars = setCars;
	}
	public CarProducer(String producerID, String procuderName, String address, String country, List<Car> setCars) {
		super();
		this.producerID = producerID;
		this.procuderName = procuderName;
		this.address = address;
		this.country = country;
		this.setCars = setCars;
	}
	public CarProducer() {
		super();
	}
	
	
}
