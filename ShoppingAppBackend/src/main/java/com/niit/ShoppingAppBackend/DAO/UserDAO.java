package com.niit.ShoppingAppBackend.DAO;

import java.util.List;

import com.niit.ShoppingAppBackend.model.User;

public interface UserDAO {
	public boolean insert(User user);
	public User getUserByEmail(String email);
	public List<User> getSuppliers();
}
