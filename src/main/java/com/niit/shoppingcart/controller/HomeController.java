package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

@RequestMapping("/")
	public String gotoHome(Model model)
	{
	model.addAttribute("Homepage","true");	
	return "index";
	}

/*@RequestMapping("/ShoppingCart")
public String gotoHome1(Model model)
{
model.addAttribute("Homepage","true");	
return "Header";
}*/

@RequestMapping("/index")
public String gotoHomepage(Model model)
{
	model.addAttribute("indexpage","true");
	return "Header";
}

@RequestMapping("/validate")
public String validate(@RequestParam(name="userID") String id, @RequestParam(name="password") String pwd, Model model,HttpSession session)
{
if (id.equals("niit") && pwd.equals("niit"))
	{
		//model.addAttribute("SucessMessage","You sucessfully logged in");
		session.setAttribute("SucessMessage","You sucessfully logged in");
		return "User";
	}
else 
	{
		model.addAttribute("errorMessage","true");
		return "Header";
	}
}
	
@RequestMapping("/login")
public  ModelAndView login(Model model)
{
	ModelAndView mv=new ModelAndView("Header");
	model.addAttribute("UserClickedLogin","true");
	return mv;
}

@RequestMapping("/register")
public String register(Model model)
{
	model.addAttribute("UserClickedRegister","true");
	return "register";
}

/*@RequestMapping("/products")
public ModelAndView product(Model model)
{
	ModelAndView mv=new ModelAndView("index");
	model.addAttribute("UserClickedProducts","true");
	return mv;
}*/

/*@RequestMapping("/supplier")
public ModelAndView supplier(Model model)
{
	ModelAndView mv=new ModelAndView("index");
	model.addAttribute("UserClickedSupplier","true");
	return mv;
}*/

/*@RequestMapping("/category")
public ModelAndView categories(Model model)
{
	ModelAndView mv=new ModelAndView("index");
	model.addAttribute("UserClickedCategory","true");
	return mv;
}*/

}
