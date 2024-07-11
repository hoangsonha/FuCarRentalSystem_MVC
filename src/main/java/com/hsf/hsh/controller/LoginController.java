package com.hsf.hsh.controller;

import java.io.IOException;
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
import com.hsf.hsh.pojo.Customer;
import com.hsf.hsh.service.CarService;
import com.hsf.hsh.service.CustomerService;
import com.hsf.hsh.service.ICarService;
import com.hsf.hsh.service.ICustomerService;



@Controller
public class LoginController {
	
	private ICustomerService iCustomerService;
	private ICarService iCarService;
	
	public LoginController() {
		iCustomerService = new CustomerService("hibernate.cfg.xml");
		iCarService = new CarService("hibernate.cfg.xml");
	}

	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value="/register")
	public String RegisterAccount(HttpServletRequest request ,HttpServletResponse response, HttpSession session, RedirectAttributes redirectAttributes) throws IOException{
		String customerID = request.getParameter("customerID");
		String customerName = request.getParameter("customerName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String message = "";
		
		if(!customerID.trim().equals("") && !customerName.trim().equals("") && !email.trim().equals("") && !password.trim().equals("")) {		
			Account account = iCustomerService.getAccountByID("A2");		
			Customer customer = new Customer(customerID, customerName, null, null, null, 0, null, email, password, account);		
			iCustomerService.save(customer);	
			message = "Dang ki thanh cong!";
			redirectAttributes.addFlashAttribute("MESSAGE", message);
		}
		return "redirect:/";
	}
	
	
	@RequestMapping(value="/login")
	public String loginAccount(HttpServletRequest request ,HttpServletResponse response, HttpSession session, RedirectAttributes redirectAttributes) throws IOException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String message = "";
		if(email != null && !email.trim().equals("")) {
			if(password != null && !password.trim().equals("")) {
				Customer customer = iCustomerService.checkLogin(email, password);
				if(customer != null) {
					session.setAttribute("CUSTOMER_LOGIN", customer);
					int role = customer.getAccount().getRole();
					if(role == 1) {
						return "redirect:/admin";
					} else if(role == 2) {
						return "redirect:/home";
					} else {
						message = "Your role is not support!";
						redirectAttributes.addFlashAttribute("MESSAGE", message);
					}
				} else {
					message = "Your email or password is not correct!";
					redirectAttributes.addFlashAttribute("MESSAGE", message);
				}
			} else {
				message = "Your password is blank!";
				redirectAttributes.addFlashAttribute("MESSAGE", message);
			}
		} else {
			message = "Your email is blank!";
			redirectAttributes.addFlashAttribute("MESSAGE", message);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletResponse response, HttpSession session) throws IOException{
		Customer acc = (Customer) session.getAttribute("CUSTOMER_LOGIN");
        if(acc != null) {
            session.invalidate();
            return "redirect:/";
        }
		return "redirect:/";  
		
	}
	
	
	
	@RequestMapping(value="/admin")
	public ModelAndView adminPage(HttpServletResponse response) throws IOException{
		return new ModelAndView("admin");
	}
	
	@RequestMapping(value="/home")
	public ModelAndView homePage(HttpServletResponse response, Model model) throws IOException{
		List<Car> lists = iCarService.findAll();
		if(lists.size() > 0) {
			model.addAttribute("LIST_CARS", lists);
		}
		return new ModelAndView("home");
	}
	
	
}
