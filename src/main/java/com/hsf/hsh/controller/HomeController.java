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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hsf.hsh.pojo.Account;
import com.hsf.hsh.pojo.Car;
import com.hsf.hsh.pojo.CarRental;
import com.hsf.hsh.pojo.Customer;
import com.hsf.hsh.pojo.Review;
import com.hsf.hsh.service.CarRentalService;
import com.hsf.hsh.service.CarService;
import com.hsf.hsh.service.CustomerService;
import com.hsf.hsh.service.ICarRentalService;
import com.hsf.hsh.service.ICarService;
import com.hsf.hsh.service.ICustomerService;

@Controller
public class HomeController {

	private ICustomerService iCustomerService;
	private ICarService iCarService;
	private ICarRentalService iCarRentalService;
	
	public HomeController() {
		iCustomerService = new CustomerService("hibernate.cfg.xml");
		iCarService = new CarService("hibernate.cfg.xml");
		iCarRentalService = new CarRentalService("hibernate.cfg.xml");
	}
	
	@RequestMapping(value="/rent/{id}")
	public String RegisterAccount(@PathVariable("id") String carID, HttpServletRequest request ,HttpServletResponse response, HttpSession session, RedirectAttributes redirectAttributes) throws IOException, ParseException{
		Customer customer = (Customer) session.getAttribute("CUSTOMER_LOGIN");
		if(customer != null) {
			Car car = iCarService.findById(carID);
			SimpleDateFormat spm = new SimpleDateFormat("yyyy-MM-dd");
			String dateF = spm.format(new Date());
			Date date = spm.parse(dateF);
			
			CarRental carRental = new CarRental(customer, car, date, null, car.getRentPrice(), "on processing");
			
			iCarRentalService.save(carRental);
			String message = "Thue thanh cong!";
			redirectAttributes.addFlashAttribute("MESSAGE", message);
			return "redirect:/home";
		}
		return "redirect:/";
	}


	@RequestMapping(value="/profile")
	public ModelAndView profile(HttpServletRequest request ,HttpServletResponse response, HttpSession session, Model model) throws IOException, ParseException{
		Customer customer = (Customer) session.getAttribute("CUSTOMER_LOGIN");
		if(customer != null) {
			model.addAttribute("CUSTOMER_LOGIN", customer);
			return new ModelAndView("profile");
		}
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/history")
	public ModelAndView history(HttpServletRequest request ,HttpServletResponse response, HttpSession session, Model model) throws IOException, ParseException{
		Customer customer = (Customer) session.getAttribute("CUSTOMER_LOGIN");
		if(customer != null) {
			model.addAttribute("CUSTOMER_LOGIN", customer);
			List<CarRental> lists = iCarRentalService.getAllBySearchCustomerIDAll(customer.getCustomerID());
			if(lists.size() > 0) {
				model.addAttribute("LIST_RENTALS", lists);
			}
			return new ModelAndView("history");
		}
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value="/update/{id}")
	public String UpdaterAccount(@PathVariable("id") String customerID, HttpServletRequest request ,HttpServletResponse response, HttpSession session, RedirectAttributes redirectAttributes) throws IOException, ParseException{
		Customer customer = (Customer) session.getAttribute("CUSTOMER_LOGIN");
			if(customerID.equals(customer.getCustomerID())) {
				
				String customerName = request.getParameter("customerName");
				String birthday = request.getParameter("birthday");
				String password = request.getParameter("password");
				String identityCard = request.getParameter("identityCard");
				String licenceDate = request.getParameter("licenceDate");
				String licenceNumber = request.getParameter("licenceNumber");
				String mobile = request.getParameter("mobile");
				
				SimpleDateFormat spm = new SimpleDateFormat("yyyy-MM-dd");
				Date dob = spm.parse(birthday);
				Date licDate = spm.parse(licenceDate);
				
				customer.setEmail(customer.getEmail());
				customer.setCustomerID(customerID);
				customer.setBirthday(dob);
				customer.setCustomerName(customerName);
				customer.setIdentityCard(identityCard);
				customer.setLicenceDate(licDate);
				customer.setLicenceNumber(Integer.parseInt(licenceNumber));
				customer.setMobile(mobile);
				customer.setPassword(password);				
				iCustomerService.update(customer);			
				String message = "Update thanh cong!";
				redirectAttributes.addFlashAttribute("MESSAGE", message);
				return "redirect:/profile";
			}

		return "redirect:/";
	}
	
	@RequestMapping(value="/review")
	public ModelAndView review(HttpSession session, Model model, RedirectAttributes redirectAttributes) throws IOException, ParseException{
		Customer customer = (Customer) session.getAttribute("CUSTOMER_LOGIN");
		if(customer != null) {
			List<Review> lists = iCarRentalService.getReviewUser(customer.getCustomerID());
			if(lists.size() > 0) {
				model.addAttribute("LIST_REVIEWS", lists);
			} else {
				redirectAttributes.addFlashAttribute("MESSAGE", "You dont rent any car!!!");
			}
			return new ModelAndView("review");
		}
		return new ModelAndView("login");
	}
	
	
}
