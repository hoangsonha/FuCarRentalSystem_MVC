package com.hsf.hsh.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hsf.hsh.pojo.Account;
import com.hsf.hsh.pojo.Customer;


public class CustomerDAO {
	private SessionFactory sessionFactory = null;
	private Configuration cf = null;
	public CustomerDAO(String per) {
		cf = new Configuration();
		cf = cf.configure(per);
		sessionFactory = cf.buildSessionFactory();
	}
	
	public Customer checkLogin(String email, String password) {
		Customer customer = null;
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {		
	        customer = (Customer) session.createQuery("FROM Customer WHERE email = :email")
	        		.setParameter("email", email)
	        		.getSingleResult();
			if(customer.getPassword().equals(password) && customer != null) {
				return customer;
			}
		} catch(Exception e) {
			t.rollback();
			System.out.println("ERROR " + e.getMessage());
		} finally {
			session.close();
		}
		return null;
	}
	
	public void save(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(customer);
			t.commit();
			System.out.println("successfully saved");
		} catch(Exception e) {
			t.rollback();
			System.out.println("ERROR " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		Session session = sessionFactory.openSession();
		try {
			customers = session.createQuery("FROM Customer").getResultList();
		} catch (Exception ex) {
			System.out.println("Error " + ex.getMessage());
		} finally {
			session.close();
		}
		return customers;
	}
	
	public void delete(String customerID) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Customer customer = (Customer) session.get(Customer.class, customerID);
			session.delete(customer);
			tx.commit();
		} catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public Customer findById(String customerID) {
		Session session = sessionFactory.openSession();
		try {
			return (Customer) session.get(Customer.class, customerID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	public void update(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(customer);
			t.commit();
			System.out.println("update saved");
		} catch(Exception e) {
			t.rollback();
			System.out.println("ERROR " + e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public Account findAccountById(String accountID)  {
		Session session = sessionFactory.openSession();
		try {
			return (Account) session.get(Account.class, accountID);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
}
