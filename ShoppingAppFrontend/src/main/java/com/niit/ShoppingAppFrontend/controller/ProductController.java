package com.niit.ShoppingAppFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingAppBackend.DAO.CategoryDAO;
import com.niit.ShoppingAppBackend.DAO.ProductDAO;

@Controller
@RequestMapping(value="/product")
public class ProductController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value="/show/all/active/products")
	public ModelAndView showProductList()
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","ShoppingApp Frontend");
		mv.addObject("categoryList",categoryDAO.activeCategoryList());
		mv.addObject("productList",productDAO.getAllActiveProducts());
		mv.addObject("userclickallproducts",true);
		return mv;
	}
	@RequestMapping(value="/show/all/active/category/{id}/products")
	public ModelAndView showProductList(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","ShoppingApp Frontend");
		mv.addObject("categoryList",categoryDAO.activeCategoryList());
		mv.addObject("category",categoryDAO.getCategory(id));
		mv.addObject("productList",productDAO.getAllActiveProductsByCategory(id));
		mv.addObject("userclickcategoryproducts",true);
		return mv;
	}
	@RequestMapping(value="/show/single/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id)
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","ShoppingApp Frontend");
		mv.addObject("product",productDAO.getProduct(id));
		System.out.println(productDAO.getProduct(id).getPublisherName());
		mv.addObject("userclicksingleproduct",true);
		return mv;
	}
}
