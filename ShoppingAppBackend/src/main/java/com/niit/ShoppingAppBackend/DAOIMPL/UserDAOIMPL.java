package com.niit.ShoppingAppBackend.DAOIMPL;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.ShoppingAppBackend.DAO.UserDAO;
import com.niit.ShoppingAppBackend.model.User;

@Transactional
@Repository("userDAO")
public class UserDAOIMPL implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean insert(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserByEmail(String email) {
		try {
		String selectActiveCategory = "FROM User WHERE email = :email";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("email", email);
						
		return (User)query.getSingleResult();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public List<User> getSuppliers() {
		try {
		String selectActiveCategory = "FROM User WHERE role = :email";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("role", "SUPPLIER");
						
		return query.getResultList();
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
