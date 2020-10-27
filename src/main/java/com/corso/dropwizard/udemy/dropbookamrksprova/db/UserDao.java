package com.corso.dropwizard.udemy.dropbookamrksprova.db;

import org.hibernate.SessionFactory;

import com.corso.dropwizard.udemy.dropbookamrksprova.core.User;

import io.dropwizard.hibernate.AbstractDAO;

public class UserDao extends AbstractDAO<User>{

	public UserDao(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
	

}
