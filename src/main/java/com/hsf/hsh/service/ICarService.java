package com.hsf.hsh.service;

import java.util.List;

import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.CarProducer;

public interface ICarService {
	public List<Car> findAll();
	public void save(Car car);
	public void delete(String carID);
	public Car findById(String carID);
	public void update(Car car);
	public CarProducer findCarProducerById(String producerID);
}
