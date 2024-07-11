package com.hsf.hsh.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hsf.hsh.pojo.Account;
import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.CarProducer;
import com.hsf.hsh.pojo.CarRental;
import com.hsf.hsh.pojo.Customer;
import com.hsf.hsh.pojo.Review;
import com.hsf.hsh.service.CarRentalService;
import com.hsf.hsh.service.CarService;
import com.hsf.hsh.service.CustomerService;
import com.hsf.hsh.service.ICarRentalService;
import com.hsf.hsh.service.ICarService;
import com.hsf.hsh.service.ICustomerService;

import net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reducing;

@Controller
public class AdminController {
	
	private ICustomerService iCustomerService;
	private ICarService iCarService;
	private ICarRentalService iCarRentalService;
	
	public AdminController() {
		iCustomerService = new CustomerService("hibernate.cfg.xml");
		iCarService = new CarService("hibernate.cfg.xml");
		iCarRentalService = new CarRentalService("hibernate.cfg.xml");
	}
	
	@RequestMapping(value="/adminCustomer")
	public ModelAndView adminPageCustomer(HttpServletResponse response, Model model) throws IOException{
		List<Customer> lists = iCustomerService.findAll();
		if(lists.size() > 0) {
			model.addAttribute("LIST_CUSTOMERS", lists);
		}
		return new ModelAndView("adminCustomer");
	}
	
	
	@RequestMapping(value="/adminManagerCustomer")
	public String adminPageCustomerManagerCustomer(HttpServletRequest request, Model model) throws IOException, ParseException{
		String type = request.getParameter("btnManager");
		String customerID = request.getParameter("customerID");
		String customerName = request.getParameter("customerName");
		String email = request.getParameter("email");
		String identityCard = request.getParameter("identityCard");
		String licenceDate = request.getParameter("licenceDate");
		String licenceNumber = request.getParameter("licenceNumber");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		String accountID = request.getParameter("accountID");
		String birthday = request.getParameter("birthday");
		
		SimpleDateFormat spm = new SimpleDateFormat("yyyy-MM-dd");
		Date liDate = spm.parse(licenceDate);
		Date dob = spm.parse(birthday);
		
		Account account = iCustomerService.getAccountByID(accountID);
		
		Customer customer = new Customer(customerID, customerName, mobile, dob, identityCard, Integer.parseInt(licenceNumber), liDate, email, password, account);
		
		switch(type) {
		case "add":
			iCustomerService.save(customer);
		break;
		case "update":
			customer.setCustomerID(customerID);
			iCustomerService.update(customer);
		break;
		case "delete":
			iCustomerService.delete(customerID);
		break;
		}
		
		return "redirect:/adminCustomer";
	}
	
	@RequestMapping(value="/adminManagerCar")
	public String adminPageCustomerManagerCar(HttpServletRequest request, Model model) throws IOException, ParseException{
		String type = request.getParameter("btnManager");
		String carID = request.getParameter("carID");
		String carName = request.getParameter("carName");
		String carModelYear = request.getParameter("carModelYear");
		String color = request.getParameter("color");
		String capacity = request.getParameter("capacity");
		String description = request.getParameter("description");
		String importDate = request.getParameter("importDate");
		String producerID = request.getParameter("producerID");
		String rentPrice = request.getParameter("rentPrice");
		String status = request.getParameter("status");
		
		SimpleDateFormat spm = new SimpleDateFormat("yyyy-MM-dd");
		Date imDate = spm.parse(importDate);
		
		CarProducer carPro = iCarService.findCarProducerById(producerID);
		
		Car car = new Car(carID, carName, carModelYear, color, capacity, description, imDate, carPro, Double.parseDouble(rentPrice), status);
		
		switch(type) {
		case "add":
			
			iCarService.save(car);
		break;
		case "update":
			car.setCarID(carID);
			iCarService.update(car);
		break;
		case "delete":
			iCarService.delete(carID);
		break;
		}
		
		return "redirect:/adminCar";
	}
	
	
	@RequestMapping(value="/adminCar")
	public ModelAndView adminPageCar(HttpServletResponse response, Model model) throws IOException{
		List<Car> lists = iCarService.findAll();
		if(lists.size() > 0) {
			model.addAttribute("LIST_CARS", lists);
		}
		return new ModelAndView("adminCar");
	}
	
	
	@RequestMapping(value="/adminManagerCarRental")
	public String adminPageCustomerManagerRental(HttpServletRequest request, Model model, RedirectAttributes redirectAttributes) throws IOException, ParseException{
		String type = request.getParameter("btnManager");
		String carRentalID = request.getParameter("carRentalID");
		String customer = request.getParameter("customer");
		String car = request.getParameter("car");
		String pickupDate = request.getParameter("pickupDate");
		String returnDate = request.getParameter("returnDate");
		String rentPrice = request.getParameter("rentPrice");
		String status = request.getParameter("status");
		
		SimpleDateFormat spm = new SimpleDateFormat("yyyy-MM-dd");
		Date pickDate = spm.parse(pickupDate);
		Date retuDate = spm.parse(returnDate);
		
		
		if(pickDate.before(retuDate)) {
			Car car2 = iCarService.findById(car);
			
			Customer customer2 = iCustomerService.findById(customer);
			
			CarRental carrental = new CarRental(customer2, car2, pickDate, retuDate, Double.parseDouble(rentPrice), status);
			
			switch(type) {
			case "add":
				
				iCarRentalService.save(carrental);
			break;
			case "update":
				carrental.setCarRentalID(Integer.parseInt(carRentalID));
				iCarRentalService.update(carrental);
			break;
			case "delete":
				iCarRentalService.delete(Integer.parseInt(carRentalID));
			break;
			}
			
		} else {
			redirectAttributes.addFlashAttribute("MESSAGE", "PickupDate must be before ReturnDate");
		}
			

		return "redirect:/adminRental";
	}
	
	@RequestMapping(value="/adminRental")
	public ModelAndView adminPageRental(HttpServletResponse response, Model model) throws IOException{
		List<CarRental> lists = iCarRentalService.findAll();
		if(lists.size() > 0) {
			model.addAttribute("LIST_RENTALS", lists);
		}
		return new ModelAndView("adminCarRental");
	}
	
	
	@RequestMapping(value="/adminReport")
	public String adminPageRentalReport(HttpServletRequest request, Model model, HttpSession session) throws IOException, ParseException{
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		int size = 0;
		try {
			
			SimpleDateFormat spm = new SimpleDateFormat("yyyy-MM-dd");
			Date sDate = spm.parse(startDate);
			Date eDate = spm.parse(endDate);
			
			
			
			List<CarRental> lists = iCarRentalService.getAllBySearch(sDate, eDate);
			size = lists.size();
			System.out.println(lists.size());
			
			if(lists.size() > 0) {
				session.setAttribute("LISTS", lists);
				return "redirect:/admin";
			}
		} catch(Exception e) {
			
			System.out.println("ERROR at " + e.toString() );
			System.out.println("size" + size);
		}
		
		return "redirect:/admin";
		
	}
	
	
	@RequestMapping(value="/adminReview")
	public ModelAndView adminPageReview(HttpServletResponse response, Model model) throws IOException{
		List<Review> lists = iCarRentalService.findAllReviews();
		if(lists.size() > 0) {
			model.addAttribute("LIST_REVIEWS", lists);
		}
		return new ModelAndView("adminReview");
	}
	
}
