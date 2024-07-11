package com.hsf.hsh.service;

import java.util.Date;
import java.util.List;

import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.CarRental;
import com.hsf.hsh.pojo.Review;
import com.hsf.hsh.repository.CarRentalRepository;
import com.hsf.hsh.repository.CarRepository;
import com.hsf.hsh.repository.ICarRentalRepository;
import com.hsf.hsh.repository.ICarRepository;

public class CarRentalService implements ICarRentalService {
	
	private ICarRentalRepository iCarRentalRepository = null;
	
	public CarRentalService(String fileName) {
		iCarRentalRepository = new CarRentalRepository(fileName);
	}
	
	@Override
	public List<CarRental> findAll() {
		// TODO Auto-generated method stub
		return iCarRentalRepository.findAll();
	}

	@Override
	public void save(CarRental carRental) {
		// TODO Auto-generated method stub
		iCarRentalRepository.save(carRental);
	}

	@Override
	public void delete(int carRentalID) {
		// TODO Auto-generated method stub
		iCarRentalRepository.delete(carRentalID);
	}

	@Override
	public CarRental findById(int carRentalID) {
		// TODO Auto-generated method stub
		return iCarRentalRepository.findById(carRentalID);
	}

	@Override
	public void update(CarRental carRental) {
		// TODO Auto-generated method stub
		iCarRentalRepository.update(carRental);
	}

	@Override
	public List<CarRental> getAllBySearch(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return iCarRentalRepository.getAllBySearch(startDate, endDate);
	}

	@Override
	public List<CarRental> getAllBySearchCustomerID(Date startDate, Date endDate, String customerID) {
		// TODO Auto-generated method stub
		return iCarRentalRepository.getAllBySearchCustomerID(startDate, endDate, customerID);
	}

	@Override
	public List<CarRental> getAllBySearchCustomerIDAll(String customerID) {
		// TODO Auto-generated method stub
		return iCarRentalRepository.getAllBySearchCustomerIDAll(customerID);
	}

	@Override
	public List<Review> findAllReviews() {
		// TODO Auto-generated method stub
		return iCarRentalRepository.findAllReviews();
	}

	@Override
	public List<Review> getReviewUser(String customerID) {
		// TODO Auto-generated method stub
		return iCarRentalRepository.getReviewUser(customerID);
	}

}
