package com.hsf.hsh.repository;

import java.util.List;

import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.CarProducer;

public interface ICarRepository {
	public List<Car> findAll();
	public void save(Car car);
	public void delete(String carID);
	public Car findById(String carID);
	public void update(Car car);
	public CarProducer findCarProducerById(String producerID);
	
}
