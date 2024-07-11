package com.hsf.hsh.dao;

import java.util.ArrayList;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.CarProducer;
import com.hsf.hsh.pojo.CarRental;


public class CarDAO {
	private SessionFactory sessionFactory = null;
	private Configuration cf = null;
	public CarDAO(String per) {
		cf = new Configuration();
		cf = cf.configure(per);
		sessionFactory = cf.buildSessionFactory();
	}
	
	public void save(Car car) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(car);
			t.commit();
			System.out.println("successfully saved");
		} catch(Exception e) {
			t.rollback();
			System.out.println("ERROR " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public List<Car> getCars() {
		List<Car> cars = new ArrayList<Car>();
		Session session = sessionFactory.openSession();
		try {
			cars = session.createQuery("FROM Car").getResultList();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			session.close();
		}
		return cars;
	}
	
	public void delete(String carID) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Car car = (Car) session.get(Car.class, carID);
			List<CarRental> lists = car.getListCarRental();
			if(lists != null && lists.size() > 0) {
				car.setStatus("deleted");
				update(car);
				System.out.println("Car in the renting transaction");
			} else {
				session.delete(car);
			}	
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public Car findById(String carID) {
		Session session = sessionFactory.openSession();
		try {
			return (Car) session.get(Car.class, carID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public void update(Car car) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(car);
			t.commit();
			System.out.println("update saved");
		} catch(Exception e) {
			t.rollback();
			System.out.println("ERROR " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public CarProducer findProducerById(String producerID) {
		Session session = sessionFactory.openSession();
		try {
			return (CarProducer) session.get(CarProducer.class, producerID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
}
