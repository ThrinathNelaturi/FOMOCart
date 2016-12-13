package com.niit.shoppingcart.controller;


import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.User;
@Controller
public class UserController {

	@Autowired
	CategoryDAO categoryDAO;
	@Autowired
	ProductDAO productDAO;
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "Login")
	public String DisplayLogin(Model mv) {
		mv.addAttribute("userdetails", new User());
		mv.addAttribute("UserClickedLogin", "true");
		return "index";
	}
	
	@RequestMapping(value = "Registration")
	public String DisplayRegister(Model mv) {
		mv.addAttribute("user", new User());
		mv.addAttribute("categoryList", categoryDAO.list());
		mv.addAttribute("productList", productDAO.list());
		mv.addAttribute("UserClickedRegistration", "true");
		return "index";
	}

	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String UserRegister(@ModelAttribute("user") User user, ModelAndView mv) {
		user.setEnabled("TRUE");
		user.setRole("ROLE_USER");
		userDAO.saveOrUpdate(user);
		mv.addObject("message", "Registration Success");
		return "redirect:/";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/login_session_attributes")
	public String login_session_attributes(HttpSession session) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userDAO.get(username);
		session.setAttribute("userId", user.getUserId());
		session.setAttribute("name", user.getName());
		session.setAttribute("LoggedIn", "true");

		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
		.getAuthentication().getAuthorities();
		String role="ROLE_USER";
		for (GrantedAuthority authority : authorities) 
		{
		  
		     if (authority.getAuthority().equals(role)) 
		     {
		    	 session.setAttribute("UserLoggedIn", "true");
		    	 return "redirect:/";
		     
		     }
		     else 
		     {
		    	 session.setAttribute("Administrator", "true");
			return "/Admin";
		     }
		}
		return "Admin";

}
/*pradeeeppp*/
}  
