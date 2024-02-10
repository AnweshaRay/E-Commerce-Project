package com.niit.ShoppingAppBackend.DAOIMPL;

import java.util.List;

import javax.persistence.Query;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingAppBackend.DAO.CategoryDAO;
import com.niit.ShoppingAppBackend.model.Category;

@Transactional
@Repository("categoryDAO")
public class CategoryDAOIMPL implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean insert(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		try {
			category.setActive(false);
			update(category);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Category getCategory(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, id);
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Category> activeCategoryList() {
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

}
