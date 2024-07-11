package com.hsf.hsh.repository;

import java.util.Date;

import java.util.List;

import com.hsf.hsh.dao.CarRentalDAO;
import com.hsf.hsh.pojo.CarRental;
import com.hsf.hsh.pojo.Review;


public class CarRentalRepository implements ICarRentalRepository {
	
	private static CarRentalDAO carRentalDAO = null;

	public CarRentalRepository(String persistanceName) {
		if(carRentalDAO == null) {
			carRentalDAO = new CarRentalDAO(persistanceName);
		}
	}

	@Override
	public List<CarRental> findAll() {
		return carRentalDAO.getCarRentals();
	}
	
	@Override
	public void save(CarRental carRental) {
		carRentalDAO.save(carRental);
	}
	
	@Override
	public void delete(int carRentalID) {
		carRentalDAO.delete(carRentalID);
	}
	
	@Override
	public CarRental findById(int carRentalID) {
		return carRentalDAO.findById(carRentalID);
	}
	
	@Override
	public void update(CarRental carRental) {
		carRentalDAO.update(carRental);
	}

	@Override
	public List<CarRental> getAllBySearch(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return carRentalDAO.getCarRentalsBySearch(startDate, endDate);
	}

	@Override
	public List<CarRental> getAllBySearchCustomerID(Date startDate, Date endDate, String customerID) {
		// TODO Auto-generated method stub
		return carRentalDAO.getCarRentalsBySearchCustomerID(startDate, endDate, customerID);
	}

	@Override
	public List<CarRental> getAllBySearchCustomerIDAll(String customerID) {
		// TODO Auto-generated method stub
		return carRentalDAO.getCarRentalsBySearchCustomerIDAll(customerID);
	}

	@Override
	public List<Review> findAllReviews() {
		// TODO Auto-generated method stub
		return carRentalDAO.getReviews();
	}

	@Override
	public List<Review> getReviewUser(String customerID) {
		// TODO Auto-generated method stub
		return carRentalDAO.getReviewUser(customerID);
	}

}
