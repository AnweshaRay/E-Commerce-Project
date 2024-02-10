package com.niit.ShoppingAppFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingAppBackend.DAO.ProductDAO;
import com.niit.ShoppingAppBackend.DAO.UserDAO;
import com.niit.ShoppingAppBackend.model.Product;

@Controller
@RequestMapping(value="/manage")
public class ManageProductController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value="/show")
	public ModelAndView show()
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("product",new Product());
		mv.addObject("categoryList",productDAO.getAllProducts());
		mv.addObject("supplierList",userDAO.getSuppliers());
		mv.addObject("userclickmanageproduct",true);
		return mv;
	}
}
