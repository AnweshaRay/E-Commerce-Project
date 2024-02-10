package com.niit.ShoppingAppBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingAppBackend.DAO.CategoryDAO;
import com.niit.ShoppingAppBackend.DAO.ProductDAO;
import com.niit.ShoppingAppBackend.DAO.UserDAO;
import com.niit.ShoppingAppBackend.model.Category;
import com.niit.ShoppingAppBackend.model.Product;
import com.niit.ShoppingAppBackend.model.User;

public class ProductTest {
	private User u;
	private Category c;
	private Product p;
	private static UserDAO userDAO;
	private static CategoryDAO categoryDAO;
	private static ProductDAO productDAO;
	
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingAppBackend");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	//@Test
	public void insertTest()
	{
		p=new Product();
		p.setName("To Kill a Mockingbird");
		p.setPublisherName("‎Arrow Books Ltd");
		p.setAuthor("Harper Lee");
		p.setDescription("Set during the Great Depression in the fictional town of Maycomb, Alabama, \"To Kill a Mockingbird\" revolves around Jean Louise Finch, an intelligent yet unconventional girl whose age ranges from six to nine in the three years that the novel covers.");
		p.setQuantity(17);
		c=categoryDAO.getCategory(38);
		p.setCategoryId(c.getId());
		p.setSupplierId(41);
		p.setUnitPrice(275);
		
		assertEquals("Error",true,productDAO.insertProduct(p));
	}
	//@Test
	public void updateTest()
	{
		p=productDAO.getProduct(47);
		p.setQuantity(35);;
		assertEquals("Error",true,productDAO.updateProduct(p));
	}
	//@Test
	public void listProductTest()
	{
		assertEquals("Error",5,productDAO.getAllProducts().size());
	}
	//@Test
	public void listActiveProductTest()
	{
		assertEquals("Error",4,productDAO.getAllActiveProducts().size());
	}
	//@Test
	public void listActiveProductByCategoryTest()
	{
		assertEquals("Error",0,productDAO.getAllActiveProductsByCategory(36).size());
	}
}
