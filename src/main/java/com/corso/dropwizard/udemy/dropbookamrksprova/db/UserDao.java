package com.corso.dropwizard.udemy.dropbookamrksprova.db;

import java.util.List;
import org.hibernate.SessionFactory;
import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.google.common.base.Optional;

import io.dropwizard.hibernate.AbstractDAO;

public class UserDao extends AbstractDAO<User>{

	public UserDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	public List<User> findAll(){
		return list(namedQuery("User.findAll"));
	}
	
	
	public Optional<User> findByUsernameAndPassword(String username, String password){
		
		Optional<User> response = Optional.fromNullable(uniqueResult(namedQuery("User.findByUsernameAndPassword")
				.setParameter("username", username)
				.setParameter("password", password)
				));
			
			if(!response.isPresent()) {
				return Optional.absent();
			}
			
			return response;
	}

}
