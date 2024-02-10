package com.niit.ShoppingAppFrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingAppBackend.DAO.ProductDAO;
import com.niit.ShoppingAppBackend.model.Product;

@Controller
@RequestMapping(value="/json")
public class JsonController {
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/show/all/active/products")
	@ResponseBody
	public List<Product> allActiveProducts()
	{
		ModelAndView mv=new ModelAndView("index");
		return productDAO.getAllActiveProducts();
	}
	@RequestMapping(value="/show/all/active/category/{id}/products")
	@ResponseBody
	public List<Product> showProductList(@PathVariable("id") int id)
	{
		return productDAO.getAllActiveProductsByCategory(id);
	}
}
