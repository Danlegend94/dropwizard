package com.corso.dropwizard.udemy.dropbookamrksprova.db.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.SessionFactory;

import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;
import com.corso.dropwizard.udemy.dropbookamrksprova.db.UserDaoService;
import com.google.common.base.Optional;
import io.dropwizard.hibernate.AbstractDAO;

public class UserDaoServiceImpl extends AbstractDAO<User> implements UserDaoService{

	public UserDaoServiceImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	@Override
	public User save(User user) {
		return persist(user);
	}
	
	@Override
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
	
	@Override
	public List<User> findAll(){
		return list(namedQuery("User.findAll"));
	}
	
	@Override
	public User update(User user, User updateUser) {
		user.setUsername(updateUser.getUsername());
		user.setPassword(updateUser.getPassword());
		user.setName(updateUser.getName());
		user.setLastName(updateUser.getLastName());
		return persist(user);
	}
	

	@Override
	public void delete(Long id) {
			namedQuery("User.remove") 
		  .setParameter("id", id) 
		  .executeUpdate();
		 
	}

}

