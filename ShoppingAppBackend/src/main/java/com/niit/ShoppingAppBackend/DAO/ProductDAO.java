package com.niit.ShoppingAppBackend.DAO;

import java.util.List;

import com.niit.ShoppingAppBackend.model.Product;

public interface ProductDAO {
	public boolean insertProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int p_id);
	public List<Product> getAllProducts();
	public List<Product> getAllActiveProducts();
	public List<Product> getAllActiveProductsByCategory(int categoryId);
}
