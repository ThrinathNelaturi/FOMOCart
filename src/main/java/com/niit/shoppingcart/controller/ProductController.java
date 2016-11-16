package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/*import org.springframework.web.servlet.ModelAndView;*/
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

@Controller
public class ProductController {
	
		@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value="/Product")
	public String getAllData(@ModelAttribute("product")Product product,BindingResult result,Model model)
	{
	model.addAttribute("productList",productDAO.list());
	model.addAttribute("UserClickedProducts","true");
		return "index";
	}
	
	
	@RequestMapping(value="/addProduct",method = RequestMethod.POST)
   public String addItem(@ModelAttribute("product") Product product){
		
		this.productDAO.save(product);
		return "redirect:/Product";
		
	}
	@RequestMapping(value="/editById/{id}",method = RequestMethod.GET)
	public String editProduct(@PathVariable("id") int id, RedirectAttributes attributes) {
		System.out.println("editProduct");
		attributes.addFlashAttribute("product", this.productDAO.get(id));
		
		return "redirect:/Product";
	}	
	@RequestMapping(value="/deleteById/{id}",method = RequestMethod.GET)
	public String deleteItem(@PathVariable("id") int id)
	{
		productDAO.delete(id);
		return "redirect:/Product";
		
}
}
