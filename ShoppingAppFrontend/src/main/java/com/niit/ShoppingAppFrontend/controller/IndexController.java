package com.niit.ShoppingAppFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShoppingAppBackend.DAO.CategoryDAO;

@Controller
public class IndexController {
	
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView home()
	{
		ModelAndView mv=new ModelAndView("index");
		mv.addObject("title","ShoppingApp Frontend");
		mv.addObject("categoryList",categoryDAO.activeCategoryList());
		mv.addObject("userclickhome",true);
		return mv;
	}
}
