package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;

	@RequestMapping(value="/Supplier")
	public String getAllData(@ModelAttribute("supplier")Supplier supplier,BindingResult result,Model model)
	{
	model.addAttribute("SupplierList",supplierDAO.list());
	model.addAttribute("UserClickedSupplier","true");
		return "index";
	}

	@RequestMapping(value="/addSupplier",method = RequestMethod.POST)
	   public String addItem(@ModelAttribute("supplier") Supplier supplier){
			
			this.supplierDAO.save(supplier);
			return "redirect:/Supplier";
			
		}
	
	@RequestMapping(value="/editBySId/{sid}",method = RequestMethod.GET)
	public String editProduct(@PathVariable("sid") int sid, RedirectAttributes attributes) 
	{
		System.out.println("editSupplier");
		attributes.addFlashAttribute("supplier", this.supplierDAO.get(sid));
		
		return "redirect:/Supplier";
	}	
	
	@RequestMapping(value="/deleteBySId/{sid}",method = RequestMethod.GET)
	public String deleteItem(@PathVariable("sid") int sid)
	{
		supplierDAO.delete(sid);
		return "redirect:/Supplier";	

	}
}

