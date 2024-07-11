package com.hsf.hsh.dao;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hsf.hsh.pojo.CarRental;
import com.hsf.hsh.pojo.Review;

public class CarRentalDAO {
	private SessionFactory sessionFactory = null;
	private Configuration cf = null;
	public CarRentalDAO(String per) {
		cf = new Configuration();
		cf = cf.configure(per);
		sessionFactory = cf.buildSessionFactory();
	}
	
	public void save(CarRental carRental) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(carRental);
			t.commit();
			System.out.println("successfully saved");
		} catch(Exception e) {
			t.rollback();
			System.out.println("ERROR " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public List<CarRental> getCarRentals() {
		List<CarRental> carRentals = new ArrayList<CarRental>();
		Session session = sessionFactory.openSession();
		try {
			carRentals = session.createQuery("FROM CarRental").getResultList();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			session.close();
		}
		return carRentals;
	}
	
	public void delete(int carRentalID) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			CarRental carRental = (CarRental) session.get(CarRental.class, carRentalID);
			session.delete(carRental);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public CarRental findById(int carRentalID) {
		Session session = sessionFactory.openSession();
		try {
			return (CarRental) session.get(CarRental.class, carRentalID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public void update(CarRental carRental) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(carRental);
			t.commit();
			System.out.println("update saved");
		} catch(Exception e) {
			t.rollback();
			System.out.println("ERROR " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public List<CarRental> getCarRentalsBySearch(Date startDate, Date endDate) {
		List<CarRental> carRentals = new ArrayList<CarRental>();
		Session session = sessionFactory.openSession();
		try {
			carRentals = session.createQuery("FROM CarRental where pickupDate >= :startDate and returnDate <= :endDate order by returnDate desc").setParameter("startDate", startDate).setParameter("endDate", endDate).getResultList();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			session.close();
		}
		return carRentals;
	}
	
	public List<CarRental> getCarRentalsBySearchCustomerID(Date startDate, Date endDate, String customerID) {
		List<CarRental> carRentals = new ArrayList<CarRental>();
		Session session = sessionFactory.openSession();
		try {
			carRentals = session.createQuery("FROM CarRental where customerID = :customerID and pickupDate >= :startDate and returnDate <= :endDate order by returnDate desc")
					.setParameter("customerID", customerID).setParameter("startDate", startDate).setParameter("endDate", endDate).getResultList();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			session.close();
		}
		return carRentals;
	}
	
	public List<CarRental> getCarRentalsBySearchCustomerIDAll(String customerID) {
		List<CarRental> carRentals = new ArrayList<CarRental>();
		Session session = sessionFactory.openSession();
		try {
			carRentals = session.createQuery("FROM CarRental where customerID = :customerID order by returnDate desc")
					.setParameter("customerID", customerID).getResultList();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			session.close();
		}
		return carRentals;
	}
	
	public List<Review> getReviews() {
		List<Review> reviews = new ArrayList<Review>();
		Session session = sessionFactory.openSession();
		try {
			reviews = session.createQuery("FROM Review").getResultList();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			session.close();
		}
		return reviews;
	}
	
	public List<Review> getReviewUser(String customerID) {
		List<Review> reviews = new ArrayList<Review>();
		Session session = sessionFactory.openSession();
		try {
			reviews = session.createQuery("FROM Review where customerID = :customerID order by id desc")
					.setParameter("customerID", customerID).getResultList();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			session.close();
		}
		return reviews;
	}
}
