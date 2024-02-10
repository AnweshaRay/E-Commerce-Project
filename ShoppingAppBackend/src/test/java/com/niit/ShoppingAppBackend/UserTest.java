package com.niit.ShoppingAppBackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.ShoppingAppBackend.DAO.UserDAO;
import com.niit.ShoppingAppBackend.model.User;

public class UserTest {
	
	private User u;
	private static UserDAO userDAO;
	private static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.ShoppingAppBackend");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Test
	public void insertUserTest()
	{
		u=new User();
		u.setFirstName("Bookipedia");
		u.setLastName("retail");
		u.setContactNumber("8876259786");
		u.setEmail("bookipedia@gmail.com");
		u.setEnabled(true);
		u.setPassword("bookipedia@00002");
		u.setRole("SUPPLIER");
		assertEquals("Error",true,userDAO.insert(u));
	}
	//@Test
	public void getUserByEmailTest()
	{
		u=userDAO.getUserByEmail("ebookadmin@gmail.com");
			
		assertEquals("Error","Ebook",u.getFirstName());
	}
}
