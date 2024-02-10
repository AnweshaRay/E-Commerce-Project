package com.niit.ShoppingAppBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingAppBackend.DAO.CategoryDAO;
import com.niit.ShoppingAppBackend.model.Category;

public class CategoryTest {
	private Category c;
	private static CategoryDAO categoryDAO;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingAppBackend");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	//@Test
	public void insertTest()
	{
		c=new Category();
		c.setActive(true);
		c.setCategoryName("Literary fiction");
		c.setDescription("Literary fiction is reserved for books that don’t slot neatly into more traditional genres, although it can also be used to differentiate from lighter fiction.");
		
		assertEquals("Error",true,categoryDAO.insert(c));
	}
	//@Test
	public void getCategoryTest()
	{
		c=categoryDAO.getCategory(33);
		
		assertEquals("Error","Classics",c.getCategoryName());
	}
	//@Test
	public void getCategoryListTest()
	{		
		assertEquals("Error",1,categoryDAO.activeCategoryList().size());
	}
	@Test
	public void updateCategoryTest()
	{
		c=categoryDAO.getCategory(33);
		c.setDescription("Classics encompass a range of book genres, but they always stand the test of time. A classic brilliantly articulates universal themes – like love, morality, death, adversity – and offers revelatory insight and clarity to readers of any era.");
		
		assertEquals("Error",true,categoryDAO.update(c));
	}
}
