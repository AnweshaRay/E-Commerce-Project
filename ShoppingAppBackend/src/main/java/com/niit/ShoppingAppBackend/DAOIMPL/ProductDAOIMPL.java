package com.niit.ShoppingAppBackend.DAOIMPL;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingAppBackend.DAO.ProductDAO;
import com.niit.ShoppingAppBackend.model.Product;

@Transactional
@Repository("productDAO")
public class ProductDAOIMPL implements ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean insertProduct(Product product) {
		try {
			product.setActive(true);
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
				sessionFactory.getCurrentSession().update(product);
				return true;
			}catch(Exception e)
			{
				e.printStackTrace();
				return false;
			}
	}

	@Override
	public Product getProduct(int p_id) {
		try {
		return sessionFactory.getCurrentSession().get(Product.class,p_id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			String selectActiveCategory="FROM Product";
			Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
			return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getAllActiveProducts() {
		try {
			String selectActiveCategory="FROM Product WHERE active=:active";
			Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
			query.setParameter("active",true);
			return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Product> getAllActiveProductsByCategory(int categoryId) {
		try {
			String selectActiveCategory="FROM Product WHERE active=:active and categoryId=:categoryId";
			Query query=sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
			query.setParameter("active",true);
			query.setParameter("categoryId",categoryId);
			return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
